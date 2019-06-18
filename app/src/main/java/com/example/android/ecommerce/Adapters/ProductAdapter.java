package com.example.android.ecommerce.Adapters;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.ecommerce.classesInfo.Product;
import com.example.android.ecommerce.R;
import com.example.android.ecommerce.form;
import com.squareup.picasso.Picasso;

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
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.product_page_temp, viewGroup, false);
        ProductViewHolder productViewHolder = new ProductViewHolder(view);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int position) {

       final Product product = productList.get(position);
        Uri uri=Uri.parse(product.getImage_uri());

        productViewHolder.textViewName.setText(product.getName());
        //productViewHolder.textViewBrand.setText(product.getProd_brand());
        //productViewHolder.textViewBuy.setText(product.getBuy_button());
        productViewHolder.textViewPrice.setText(String.valueOf(product.getPrice()));
        productViewHolder.description.setText(product.getDescription());
        Picasso.with(context).load(uri).into(productViewHolder.imageView);
        productViewHolder.productLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, form.class);
                intent.putExtra("Product Name",product.getName());
                intent.putExtra("Category Name",product.getCategory());
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

       // productViewHolder.setImageDrawable(context.getResources().getDrawable(product.getImage(), null));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView textViewName, textViewBrand, textViewBuy, textViewPrice, description;
    CardView productLayout;


    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView=itemView.findViewById(R.id.product_imageView);
        //textViewBrand=itemView.findViewById(R.id.product_brand);
        textViewName=itemView.findViewById(R.id.product_ViewTitle);
        textViewPrice=itemView.findViewById(R.id.product_ViewPrice);
        description=itemView.findViewById(R.id.product_ViewShortDesc);
        productLayout=itemView.findViewById(R.id.ProductLayout);
       //textViewBuy=itemView.findViewById(R.id.product_buy_button);
    }
}

}


