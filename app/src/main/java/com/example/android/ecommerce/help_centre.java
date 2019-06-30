package com.example.android.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class help_centre extends AppCompatActivity {

    ImageView call, mail;
    String cust_care_number="9315320663";
    String cust_care_email="innogeeksndroid@gmail.com";
    TextView b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_centre);

        call=findViewById(R.id.call_img);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                final Intent intent = callIntent.setData(Uri.parse("tel:" + cust_care_number));
                startActivity(intent);
            }
        });

        mail=findViewById(R.id.mail_img);

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent email = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + cust_care_email));
//                email.putExtra(Intent.EXTRA_EMAIL, cust_care_email);


                //need this to prompts email client only
//                email.setDataAndType(Uri.parse(cust_care_email),"message/rfc822");

                startActivity(Intent.createChooser(email,cust_care_email ));
                Toast.makeText(getApplicationContext(),"Email sent successfully",Toast.LENGTH_SHORT).show();
            }
        });

        b1= findViewById(R.id.cancel_button);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v1) {

                Intent home = new Intent(help_centre.this, FirstPage.class);
                startActivity(home);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });


        b2= findViewById(R.id.done_button);

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v1) {

                Intent home = new Intent(help_centre.this, FirstPage.class);
                startActivity(home);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });
    }
}
