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
    EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10, editText11, editText12;

    TextInputLayout textInput1, textInput2, textInput3, textInput4, textInput5, textInput6, textInput7, textInput8, textInput9, textInput10, textInput11, textInput12;
    Button save;

    FirebaseDatabase userInfo=FirebaseDatabase.getInstance();
    DatabaseReference Mainref=userInfo.getReference();
    FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
    ProgressDialog loadingBar;
    HashMap<String,Object>userInfomap=new HashMap<>();
    UserInfoForDatabase userClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_description);
        iconCart = findViewById(R.id.icon_cart);


        ViewPager viewpager = findViewById(R.id.temp_view_pager);

        ImageAdapter adapter = new ImageAdapter(this);
        viewpager.setAdapter(adapter);
        save = (Button) findViewById(R.id.Save_Button);

        editText1 = findViewById(R.id.temp_user_name);
        editText2 = findViewById(R.id.temp_user_mobile);
        editText3 = findViewById(R.id.temp_user_address);
        editText4 = findViewById(R.id.temp_user_city);
        editText5 = findViewById(R.id.temp_user_state);
        editText6 = findViewById(R.id.temp_user_email);
        editText7 = findViewById(R.id.temp_user_website_url);
        editText8=findViewById(R.id.temp_user_instagram_url);
        editText9=findViewById(R.id.temp_user_facebook_url);
        editText10 = findViewById(R.id.temp_user_linked_in_url);
        editText11 = findViewById(R.id.temp_user_designation);
        editText12 = findViewById(R.id.temp_user_work_type);

        textInput1 = findViewById(R.id.text_layout_name);
        textInput2 = findViewById(R.id.text_layout_mobile);
        textInput3 = findViewById(R.id.text_layout_address);
        textInput4 = findViewById(R.id.text_layout_city);
        textInput5 = findViewById(R.id.text_layout_state);
        textInput6 = findViewById(R.id.text_layout_email);
        textInput7 = findViewById(R.id.text_layout_website_url);
        textInput8=findViewById(R.id.text_layout_instagram_url);
        textInput9=findViewById(R.id.text_layout_facebook_url);
        textInput10 = findViewById(R.id.text_layout_linked_in_url);
        textInput11 = findViewById(R.id.text_layout_designation);
        textInput12 = findViewById(R.id.text_layout_work_type);

        loadingBar=new ProgressDialog(this);
        userClass=new UserInfoForDatabase();
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
        int city = editText4.getText().toString().trim().length();
        int state = editText5.getText().toString().trim().length();
        int email = editText6.getText().toString().trim().length();
        int designation = editText11.getText().toString().trim().length();
        int work_type = editText12.getText().toString().trim().length();

        int flag = 0;

            if (Name == 0 || phone == 0 || address == 0 ||city==0||state==0|| email == 0 || designation == 0 || work_type == 0) {
                if (Name == 0) {
                    textInput1.setError("This field needs to be filled");

                }
                if (phone==0) {


                    textInput2.setError("This field needs to be filled");
                }
                if (address == 0)
                {

                    textInput3.setError("This field needs to be filled");
                }

                if (city == 0) {

                    textInput4.setError("This field needs to be filled");
                }

                if (state == 0) {

                    textInput5.setError("This field needs to be filled");
                }
                if (email == 0) {

                    textInput6.setError("This field needs to be filled");
                }
                if (designation == 0) {

                    textInput11.setError("This field needs to be filled");
                }
                if (work_type == 0) {

                    textInput12.setError("This field needs to be filled");
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
        final String city = editText4.getText().toString();
        final String state = editText5.getText().toString();
        final String email = editText6.getText().toString();
        final String website = editText7.getText().toString();
//        final String instagram=editText8.getText().toString().trim().length();
//        final String facebook=editText9.getText().toString().trim().length();
//        final String linked_in=editText10.getText().toString().trim().length();
        final String designation = editText11.getText().toString();
        final String work_type = editText12.getText().toString();
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
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Mainref.child(uid).setValue(userClass)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful())
                                {
                                    Toast.makeText(ProjectDescription.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                                    loadingBar.dismiss();
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

}

