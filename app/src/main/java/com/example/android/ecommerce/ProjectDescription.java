package com.example.android.ecommerce;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProjectDescription extends AppCompatActivity {
    ImageView iconCart;
    Button sXS,sS,sM,sL,sXL,sXXL;
    TextView ProductBrand,ProductName,ProductPrice,ProductMRP,ProductDiscount;
    TextView SizeChart,WishList,Cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_description);
        iconCart=(ImageView)findViewById(R.id.icon_cart);
        sXS=(Button)findViewById(R.id.ExtraSmall);
        sS=(Button)findViewById(R.id.Small);
        sM=(Button)findViewById(R.id.Medium);
        sL=(Button)findViewById(R.id.Large);
        sXL=(Button)findViewById(R.id.ExtraLarge);
        sXXL=(Button)findViewById(R.id.ExtraExtraLarge);

        ViewPager viewpager = findViewById(R.id.cloth1_view_pager);

        ImageAdapter adapter = new ImageAdapter(this);
        viewpager.setAdapter(adapter);
    }
}
