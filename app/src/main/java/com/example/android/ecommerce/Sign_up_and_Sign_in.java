package com.example.android.ecommerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class Sign_up_and_Sign_in extends AppCompatActivity {
    Button SignIn,SignUp;
    //Intent tSignUp;
    Intent tSignIn;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        SignUp=(Button)findViewById(R.id.button_sign_up);
        SignIn=(Button)findViewById(R.id.button_sign_in);
//        tSignUp=new Intent(Sign_up_and_Sign_in.this,Authentication.class);

        setContentView(R.layout.activity_sign_up_and__sign_in);
        //SignUp=(Button)findViewById(R.id.button_sign_up);
        SignIn=(Button)findViewById(R.id.button_sign_in);
        tSignIn=new Intent(Sign_up_and_Sign_in.this,Authentication.class);
        //tSignUp=new Intent(Sign_up_and_Sign_in.this, FirstPage.class);
        if(flag==0);
        {
            AuthUI.getInstance().signOut(this);
            super.onCreate(savedInstanceState);
        }
    }
//    public void toSignUp(View view)
//    {
//        startActivity(tSignUp);
//
//    }
    public void toSignIn(View view)
    {
       startActivity(tSignIn);

    }
}
