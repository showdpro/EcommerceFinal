package com.example.android.ecommerce;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.data.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class ProjectDescription extends AppCompatActivity {
    ImageView iconCart;
    TextView ProductBrand, ProductName, ProductPrice, ProductMRP, ProductDiscount;
    TextView WishList, Cart;
    EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9;

    TextInputLayout textInput1, textInput2, textInput3, textInput4, textInput5, textInput6, textInput7, textInput8, textInput9;
    LinearLayout save;

    FirebaseDatabase userInfo=FirebaseDatabase.getInstance();
    DatabaseReference Mainref=userInfo.getReference();
    DatabaseReference Existing_value=userInfo.getReference();
    FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
    ProgressDialog loadingBar;
    HashMap<String,Object>userInfomap=new HashMap<>();
    UserInfoForDatabase userClass;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_description);
        iconCart = findViewById(R.id.icon_cart);


        ViewPager viewpager = findViewById(R.id.temp_view_pager);

        ImageAdapter adapter = new ImageAdapter(this);
        viewpager.setAdapter(adapter);
        save = (LinearLayout) findViewById(R.id.Save_Button);

        editText1 = findViewById(R.id.temp_user_name);
        editText2 = findViewById(R.id.temp_user_mobile);
        editText3 = findViewById(R.id.temp_user_address);
        editText4 = findViewById(R.id.temp_user_email);
        editText5 = findViewById(R.id.temp_user_website_url);
//        editText6=findViewById(R.id.temp_user_instagram_url);
//        editText7=findViewById(R.id.temp_user_facebook_url);
        editText8 = findViewById(R.id.temp_user_designation);
        editText9 = findViewById(R.id.temp_user_work_type);

        textInput1 = findViewById(R.id.text_layout_name);
        textInput2 = findViewById(R.id.text_layout_mobile);
        textInput3 = findViewById(R.id.text_layout_address);
        textInput4 = findViewById(R.id.text_layout_email);
        textInput5 = findViewById(R.id.text_layout_website_url);
//        textInput6=findViewById(R.id.text_layout_instagram_url);
//        textInput7=findViewById(R.id.text_layout_facebook_url);
        textInput8 = findViewById(R.id.text_layout_designation);
        textInput9 = findViewById(R.id.text_layout_work_type);
        loadingBar=new ProgressDialog(this);
        userClass=new UserInfoForDatabase();
        editText1.setText(name);
        loadingBar.setTitle("Checking for previous Data");
        loadingBar.setMessage("Plaese Wait..");
        loadingBar.show();

        Mainref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               if((dataSnapshot.child("UserInfo").child(user.getUid()).exists()))
               {
                   putValuesInEditText(dataSnapshot);
               }
               else
               {
                   Toast.makeText(ProjectDescription.this, "No Existing Data Found", Toast.LENGTH_SHORT).show();
                   loadingBar.dismiss();
               }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ifAnyDetailIsEmpty();
                userInfomap.clear();
            }
        });
    }


    private void ifAnyDetailIsEmpty() {
        int Name = editText1.getText().toString().trim().length();
        int phone = editText2.getText().toString().trim().length();
        int address = editText3.getText().toString().trim().length();
        int email = editText4.getText().toString().trim().length();
        int website = editText5.getText().toString().trim().length();
//        int instagram=editText6.getText().toString().trim().length();
//        int facebook=editText7.getText().toString().trim().length();
        int designation = editText8.getText().toString().trim().length();
        int work_type = editText9.getText().toString().trim().length();

        int flag = 0;

            if (Name == 0 || phone == 0 || address == 0 || email == 0 || designation == 0 || work_type == 0) {
                if (Name == 0) {
                    textInput1.setError("This field needs to be filled");

                }
                if (phone==0) {


                    textInput2.setError("This field needs to be filled");
                }
                if (address == 0) {

                    textInput3.setError("This field needs to be filled");
                }
                if (email == 0) {

                    textInput4.setError("This field needs to be filled");
                }
                if (designation == 0) {

                    textInput8.setError("This field needs to be filled");
                }
                if (work_type == 0) {

                    textInput9.setError("This field needs to be filled");
                }
            }
            else
            {
                saveDataToDataBase();
                loadingBar.setTitle("Saving data");
                loadingBar.setMessage("Please Wait..");
                loadingBar.show();
            }


     }

    private void saveDataToDataBase() {
        final String Name = editText1.getText().toString();
        final String phone = editText2.getText().toString();
        final String address = editText3.getText().toString();
        final String email = editText4.getText().toString();
        final String website = editText5.getText().toString();
//        final String instagram=editText6.getText().toString().trim().length();
//        final String facebook=editText7.getText().toString().trim().length();
        final String designation = editText8.getText().toString();
        final String work_type = editText9.getText().toString();
        final String uid=user.getUid().toString();
        userClass.setName(Name);
        userClass.setPhone(phone);
        userClass.setAddress(address);
        userClass.setEmail(email);
        userClass.setWebsite(website);
        userClass.setDesignation(designation);
        userClass.setWorktype(work_type);
        Mainref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                Mainref.child("UserInfo").child(uid).setValue(userClass)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful())
                                {
                                    Toast.makeText(ProjectDescription.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                                    loadingBar.dismiss();
                                    //putValuesInEditText(dataSnapshot);
                                }
                                else
                                {
                                    Toast.makeText(ProjectDescription.this, "Network Error", Toast.LENGTH_SHORT).show();
                                    loadingBar.dismiss();
                                }
                            }
                        });

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void putValuesInEditText(@org.jetbrains.annotations.NotNull DataSnapshot dataSnapshot) {
        for(DataSnapshot ds:dataSnapshot.getChildren())
        {
            userClass.setName(ds.child(user.getUid()).getValue(UserInfoForDatabase.class).getName());
            userClass.setPhone(ds.child(user.getUid()).getValue(UserInfoForDatabase.class).getPhone());
            userClass.setAddress(ds.child(user.getUid()).getValue(UserInfoForDatabase.class).getAddress());
            userClass.setEmail(ds.child(user.getUid()).getValue(UserInfoForDatabase.class).getEmail());
            userClass.setWebsite(ds.child(user.getUid()).getValue(UserInfoForDatabase.class).getWebsite());
            userClass.setDesignation(ds.child(user.getUid()).getValue(UserInfoForDatabase.class).getDesignation());
            userClass.setWorktype(ds.child(user.getUid()).getValue(UserInfoForDatabase.class).getWorktype());

            editText1.setText(userClass.getName().toString());
            editText2.setText(userClass.getPhone().toString());
            editText3.setText(userClass.getAddress().toString());
            editText4.setText(userClass.getEmail().toString());
            editText5.setText(userClass.getWebsite().toString());
            editText8.setText(userClass.getDesignation().toString());
            editText9.setText(userClass.getWorktype().toString());
            loadingBar.dismiss();
        }
    }

}

