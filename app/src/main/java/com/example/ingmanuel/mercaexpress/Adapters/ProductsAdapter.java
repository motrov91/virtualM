package com.example.ingmanuel.mercaexpress.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ingmanuel.mercaexpress.Models.ProductsModel;
import com.example.ingmanuel.mercaexpress.R;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolderDatos> {

    ArrayList<ProductsModel> listProducts;

    public ProductsAdapter(ArrayList<ProductsModel> listProducts) {
        this.listProducts = listProducts;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_product, null, false);
        return new ViewHolderDatos(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int i) {
        holder.productImage.setImageResource(listProducts.get(i).getProductImage());
        holder.productName.setText(listProducts.get(i).getProductName());
        holder.productPrice.setText(listProducts.get(i).getProductPrice());
        holder.productDescription.setText(listProducts.get(i).getProductDescription());
    }

    @Override
    public int getItemCount() {
        return listProducts.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        ImageView productImage;
        TextView productName, productPrice, productDescription;
        Button btnAdd;


        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.productImage);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            productDescription = itemView.findViewById(R.id.product_description);
            btnAdd = itemView.findViewById(R.id.btnAdd);
        }
    }
}
