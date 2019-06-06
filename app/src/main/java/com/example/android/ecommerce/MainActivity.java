package com.example.android.ecommerce;

import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ImageView logo=(ImageView)findViewById(R.id.logo);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent screen= new Intent(MainActivity.this,FirstPage.class);
                startActivity(screen);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
