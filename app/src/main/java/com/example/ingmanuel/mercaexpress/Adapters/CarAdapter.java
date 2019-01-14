package com.example.ingmanuel.mercaexpress.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ingmanuel.mercaexpress.Models.CarModel;
import com.example.ingmanuel.mercaexpress.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CarAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<CarModel> listCar;

    public CarAdapter(ArrayList<CarModel> listCar, Context context) {
        this.listCar = listCar;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listCar.size();
    }

    @Override
    public Object getItem(int position) {
        return listCar.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {

        CarModel item = (CarModel) getItem(position);

        v = LayoutInflater.from(context).inflate(R.layout.item_car_product, null);
        ImageView imageBuy = v.findViewById(R.id.image_product_buy);
        TextView name = v.findViewById(R.id.name_product_buy);
        TextView description = v.findViewById(R.id.description_product_buy);
        TextView price = v.findViewById(R.id.price_product_buy);
        TextView cant = v.findViewById(R.id.cant_product_buy);

        imageBuy.setImageResource(item.getImageProduct());
        name.setText(item.getName());
        description.setText(item.getDescription());
        price.setText(String.valueOf(item.getPrice()));
        cant.setText(String.valueOf(item.getCantidad()));

        return v;
    }
}
