package com.example.android.ecommerce.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.ecommerce.Interface.ItemClickListener;
import com.example.android.ecommerce.R;

public class product_view_holder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    private TextView product_brand, product_name, product_price,
            product_mrp, product_discount;

    private ImageView imageView;

    private ItemClickListener listener;

    private Button button;

    public product_view_holder(@NonNull View itemView) {
        super(itemView);

        imageView= itemView.findViewById(R.id.product_image);


        product_brand= itemView.findViewById(R.id.product_brand);


        product_name= itemView.findViewById(R.id.product_name);


        product_price= itemView.findViewById(R.id.product_price);


        product_mrp= itemView.findViewById(R.id.product_mrp);


        product_discount= itemView.findViewById(R.id.product_discount_grid_1);

        button=itemView.findViewById(R.id.product_buy_button);


    }

    public void setItemClickListener(ItemClickListener listener)
    {
        this.listener= listener;
    }


    @Override
    public void onClick(View v) {

        listener.onClick(v, getAdapterPosition(), false);

    }
}
