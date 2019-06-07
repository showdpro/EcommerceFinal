package com.example.android.ecommerce;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProjectDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_description);

        ViewPager viewpager = findViewById(R.id.cloth1_view_pager);

        ImageAdapter adapter = new ImageAdapter(this);
        viewpager.setAdapter(adapter);
    }
}
