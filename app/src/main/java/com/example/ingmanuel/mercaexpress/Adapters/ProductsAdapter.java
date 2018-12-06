package com.example.ingmanuel.mercaexpress.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ingmanuel.mercaexpress.Models.ProductsModel;
import com.example.ingmanuel.mercaexpress.R;

import java.util.ArrayList;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolderDatos> implements Filterable {

    List<ProductsModel> listProducts;
    List<ProductsModel> listProductComplete;

    public ProductsAdapter(List<ProductsModel> listProducts) {
        this.listProducts = listProducts;
        listProductComplete = new ArrayList<>(listProducts);
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

    /**Metodo para realizar busquedas dentro del recycler**/
    @Override
    public Filter getFilter() {
        return listaCursosFiltrada;
    }

    private Filter listaCursosFiltrada = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ProductsModel> listaFiltradaDeProductos = new ArrayList<>();
            if (constraint == null || constraint.length()==0){
                listaFiltradaDeProductos.addAll(listProductComplete);
            }else{
                String filterPatter = constraint.toString().toLowerCase().trim();
                for (ProductsModel product:listProductComplete){
                    if (product.getProductName().toLowerCase().contains(filterPatter)){
                        listaFiltradaDeProductos.add(product);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = listaFiltradaDeProductos;
            return results;
        }
        /**Muestra en pantalla el resultado re la busqueda filtrada**/
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listProducts.clear();
            listProducts.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };

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
