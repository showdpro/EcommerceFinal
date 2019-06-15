package com.example.android.ecommerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyAccount extends AppCompatActivity{
    LinearLayout MyOrder,MyProfile;
    Intent myOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        MyOrder=(LinearLayout) findViewById(R.id.linear_my_orders);
        MyProfile=(LinearLayout)findViewById(R.id.linear_my_profile);
        MyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myOrder=new Intent(MyAccount.this,MyOrders.class);
                startActivity(myOrder);
            }
        });
        MyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyAccount.this,ProfileActivity.class));
            }
        });



    }
}
