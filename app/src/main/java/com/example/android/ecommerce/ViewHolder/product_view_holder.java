package com.example.android.ecommerce.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.ecommerce.Interface.ItemClickListener;
import com.example.android.ecommerce.R;

public class product_view_holder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView product_brand1, product_brand2, product_name1, product_name2, product_price1, product_price2,
            product_mrp1, product_mrp2, product_discount1, product_discount2;

    public ImageView imageView1, imageView2;

    public ItemClickListener listener;

    public product_view_holder(@NonNull View itemView) {
        super(itemView);

        imageView1= itemView.findViewById(R.id.product_image_1);
        imageView2= itemView.findViewById(R.id.product_image_2);

        product_brand1= itemView.findViewById(R.id.product_brand_grid_1);
        product_brand2= itemView.findViewById(R.id.product_brand_grid_2);

        product_name1= itemView.findViewById(R.id.product_name_grid_1);
        product_name2= itemView.findViewById(R.id.product_name_grid_2);

        product_price1= itemView.findViewById(R.id.product_price_1);
        product_price2= itemView.findViewById(R.id.product_price_2);

        product_mrp1= itemView.findViewById(R.id.product_mrp_grid_1);
        product_mrp2= itemView.findViewById(R.id.product_mrp_grid_2);

        product_discount1= itemView.findViewById(R.id.product_discount_grid_1);
        product_discount2= itemView.findViewById(R.id.product_discount_grid_2);

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
