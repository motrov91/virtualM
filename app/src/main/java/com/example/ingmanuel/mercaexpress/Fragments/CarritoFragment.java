package com.example.ingmanuel.mercaexpress.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.ingmanuel.mercaexpress.Adapters.CarAdapter;
import com.example.ingmanuel.mercaexpress.Models.CarModel;
import com.example.ingmanuel.mercaexpress.R;

import java.util.ArrayList;


public class CarritoFragment extends Fragment {

    ListView listProduct;
    CarAdapter adapter;
    ImageButton btnDelete;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CarritoFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CarritoFragment newInstance(String param1, String param2) {
        CarritoFragment fragment = new CarritoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_carrito, container, false);
        listProduct = v.findViewById(R.id.list_car);
        btnDelete = v.findViewById(R.id.delete_product_buy);

        adapter = new CarAdapter(getArrayItems(),getContext());
        listProduct.setAdapter(adapter);


        return v;
    }


    private ArrayList<CarModel> getArrayItems(){
        ArrayList<CarModel> listItems = new ArrayList<>();

        listItems.add(new CarModel("Arroz roa", "500gr", 2000, R.drawable.ahorro, 5));
        listItems.add(new CarModel("Arroz Flor Huila", "400gr", 2000, R.drawable.ahorro, 2));
        return listItems;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
