package com.example.android.ecommerce;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class SignUp extends AppCompatActivity {

    EditText name,monum,password,cpassword;
    ProgressBar Loadingbar;
    TextView showpass;
    Button CreateAcc;
    ProgressDialog loadingBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name=(EditText)findViewById(R.id.Name);
        monum=(EditText)findViewById(R.id.Mno);
        password=(EditText)findViewById(R.id.password);
        cpassword=(EditText)findViewById(R.id.Cpassword);
        showpass=(TextView)findViewById(R.id.showpass);
        CreateAcc=(Button)findViewById(R.id.createAcc);
        loadingBar= new ProgressDialog(this);
        CreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAcc();

            }
        });
    }

    private void CreateAcc()
    {

        String nam,mnum,pass,cpass;
        nam = name.getText().toString();
        mnum=monum.getText().toString();
        pass=password.getText().toString();
        cpass=cpassword.getText().toString();

        if(TextUtils.isEmpty(nam))
        {
            Toast.makeText(this, "Enter The Name", Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(mnum))
        {
            Toast.makeText(this, "Please Write Your Number", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(pass))
        {
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(cpass))
        {
            Toast.makeText(this, "Please Enter the Password", Toast.LENGTH_SHORT).show();
        }
        else if(!(pass.equals(cpass)))
        {
            Toast.makeText(this, "Please Enter the password again", Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingBar.setTitle("Creating Account");
            loadingBar.setMessage("Please Wait");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            AddAcc(nam,mnum,pass);
        }

    }

    private void AddAcc(final String nam, final String mnum,final String pass)
    {
        final DatabaseReference Rootref;
        Rootref= FirebaseDatabase.getInstance().getReference();

        Rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            if(!(dataSnapshot.child("Users").child(mnum).exists()))
            {
                HashMap<String,Object>userDataMap=new HashMap<>();
                userDataMap.put("Name",nam);
                userDataMap.put("Phone No.",mnum);
                userDataMap.put("Password",pass);
                Rootref.child("Users").child(mnum).updateChildren(userDataMap)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task)
                            {

                                if(task.isSuccessful())
                                {
                                    Toast.makeText(SignUp.this, "Data Stored", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(SignUp.this, "Network Error", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });


            }

            else
            {
                loadingBar.dismiss();
                Toast.makeText(SignUp.this, "Number is Already Present", Toast.LENGTH_SHORT).show();
            }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
