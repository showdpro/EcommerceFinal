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

    Intent goToFirstPage;

    private static final int MY_REQUEST_CODE = 7117;
    List<AuthUI.IdpConfig> providers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);


        setContentView(R.layout.activity_main);
        goToFirstPage=new Intent(Authentication.this,FirstPage.class);


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
                        .setTheme(R.style.AppTheme)
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
                GoToFirstPage();
            }
            else{
                Toast.makeText(this,""+response.getError().getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void GoToFirstPage() {
        startActivity(goToFirstPage);
    }
}
