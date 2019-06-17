package com.example.android.ecommerce;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class form extends AppCompatActivity {
    ImageView iconCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        ViewPager viewpager = findViewById(R.id.temp_view_pager);

        ImageAdapter adapter = new ImageAdapter(this);
        viewpager.setAdapter(adapter);
         iconCart = findViewById(R.id.icon_cart);


        ViewPager viewpager = findViewById(R.id.temp_view_pager);

        ImageAdapter adapter = new ImageAdapter(this);
        viewpager.setAdapter(adapter);
    }
}
