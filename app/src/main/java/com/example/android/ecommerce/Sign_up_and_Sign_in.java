package com.example.android.ecommerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sign_up_and_Sign_in extends AppCompatActivity {
    Button SignIn,SignUp;
    Intent tSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SignUp=(Button)findViewById(R.id.button_sign_up);
        SignIn=(Button)findViewById(R.id.button_sign_in);
        tSignUp=new Intent(Sign_up_and_Sign_in.this,SignUp.class);
        setContentView(R.layout.activity_sign_up_and__sign_in);
    }
    public void toSignUp(View view)
    {
        startActivity(tSignUp);

    }
}
