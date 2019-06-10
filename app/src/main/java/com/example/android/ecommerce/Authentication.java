package com.example.android.ecommerce;

import android.content.Intent;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;




import java.util.Arrays;
import java.util.List;

public class Authentication extends AppCompatActivity {


    private static final int MY_REQUEST_CODE = 7117;
    List<AuthUI.IdpConfig> providers;
    Button btn_sign_out;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_sign_out=(Button)findViewById(R.id.btn_sign_out);
        btn_sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //LogOut
                AuthUI.getInstance().signOut(Authentication.this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                btn_sign_out.setEnabled(false);
                                showSignInOptions();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Authentication.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        //Init provider
        providers= Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.PhoneBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build()
        );

        showSignInOptions();

    }

    private void showSignInOptions() {
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setTheme(R.style.MyTheme)
                        .build(),MY_REQUEST_CODE
        );
    }


    private void startActivityForResult() {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==MY_REQUEST_CODE)
        {
            IdpResponse response=IdpResponse.fromResultIntent(data);
            if(resultCode== RESULT_OK)
            {
                //Get User
                FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
                //show email on toast
                Toast.makeText(this,""+user.getEmail(),Toast.LENGTH_SHORT).show();
                //set button signout
                btn_sign_out.setEnabled(true);


            }
            else{
                Toast.makeText(this,""+response.getError().getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    }
}