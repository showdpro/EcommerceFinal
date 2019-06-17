package com.example.android.ecommerce;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder>{

    //button is left
    Context context;
    List<Order> orderList;

    public OrderAdapter(Context context, List<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderAdapter.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.my_orders_page, viewGroup, false);
        OrderAdapter.OrderViewHolder orderViewHolder = new OrderAdapter.OrderViewHolder(view);
        return orderViewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.OrderViewHolder orderViewHolder, int i) {

    Order order = orderList.get(i);

       orderViewHolder.textViewName.setText(order.getOrder_name());
      orderViewHolder.textViewBrand.setText(order.getOrder_brand());
        orderViewHolder.textViewDate.setText(order.getOrder_date());
        orderViewHolder.textViewPrice.setText(String.valueOf(order.getOrder_price()));
        orderViewHolder.textViewTime.setText(order.getOrder_time());
        // productViewHolder.setImageDrawable(context.getResources().getDrawable(product.getImage(), null));

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    class OrderViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textViewName, textViewBrand, textViewDate, textViewPrice, textViewTime;


        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.order_image);
            textViewBrand=itemView.findViewById(R.id.order_brand);
            textViewName=itemView.findViewById(R.id.order_name);
            textViewPrice=itemView.findViewById(R.id.order_price);
            textViewDate=itemView.findViewById(R.id.order_date);
            textViewTime=itemView.findViewById(R.id.order_time);

        }
    }

}

