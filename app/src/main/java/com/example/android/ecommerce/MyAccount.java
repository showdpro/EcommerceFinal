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
    TextView order;
    Intent myOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
<<<<<<< HEAD
        order=findViewById(R.id.myorders);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myOrder=new Intent(MyAccount.this,MyOrders.class);
                startActivity(myOrder);
            }
        });
=======
>>>>>>> f5035e597a17be4d6e5bb82b1876318b4e5c4b7e


    }
}
