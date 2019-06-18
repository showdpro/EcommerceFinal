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


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    Context context;
    List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.product_page_temp, viewGroup, false);
        ProductViewHolder productViewHolder = new ProductViewHolder(view);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {

       Product product = productList.get(i);

        productViewHolder.textViewName.setText(product.getProd_name());
        productViewHolder.textViewBrand.setText(product.getProd_brand());
        productViewHolder.textViewBuy.setText(product.getBuy_button());
        productViewHolder.textViewPrice.setText(String.valueOf(product.getProd_price()));
        productViewHolder.textViewName.setText(product.getProd_name());
       // productViewHolder.setImageDrawable(context.getResources().getDrawable(product.getImage(), null));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView textViewName, textViewBrand, textViewBuy, textViewPrice;


    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView=itemView.findViewById(R.id.product_image);
        textViewBrand=itemView.findViewById(R.id.product_brand);
        textViewName=itemView.findViewById(R.id.product_name);
        textViewPrice=itemView.findViewById(R.id.product_price);
        textViewBuy=itemView.findViewById(R.id.product_buy_button);
    }
}

}


