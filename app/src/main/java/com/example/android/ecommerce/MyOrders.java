package com.example.android.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.ecommerce.Adapters.OrderAdapter;
import com.example.android.ecommerce.classesInfo.Order;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MyOrders extends AppCompatActivity {
    RecyclerView recyclerView;
    OrderAdapter adapter;
    List<Order> orderList;
    Order order;
    FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        recyclerView=findViewById(R.id.my_orders_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        orderList =new ArrayList<>();

        DatabaseReference dbReference= FirebaseDatabase.getInstance().getReference("Orders");

        dbReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.child(user.getUid()).getChildren())
                {
                    order=ds.getValue(Order.class);
                    orderList.add(order);
                }
                adapter=new OrderAdapter(MyOrders.this,orderList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
