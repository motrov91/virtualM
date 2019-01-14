package com.example.ingmanuel.mercaexpress.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ingmanuel.mercaexpress.Models.ProductsModel;
import com.example.ingmanuel.mercaexpress.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProductDetail.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProductDetail#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductDetail extends Fragment implements View.OnClickListener {


    ImageView imageDetail;
    TextView nameDetail, nameCategoty, priceDetail, descDetail;
    private String textoGuardado;



    ImageButton decrease, increase;
    TextView cant_product;
    int counter = 1;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ProductDetail() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductDetail.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductDetail newInstance(String param1, String param2) {
        ProductDetail fragment = new ProductDetail();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_product_detail, container, false);

        imageDetail = v.findViewById(R.id.image_detail);
        nameDetail = v.findViewById(R.id.name_datail);
        nameCategoty = v.findViewById(R.id.nameCategory);
        priceDetail = v.findViewById(R.id.price_detail);
        descDetail = v.findViewById(R.id.description);

        decrease = v.findViewById(R.id.decrease);
        increase = v.findViewById(R.id.increase);
        cant_product = v.findViewById(R.id.cant_product);

        decrease.setOnClickListener(this);
        increase.setOnClickListener(this);

        Toolbar toolbar = v.findViewById(R.id.toolbardetail);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);


        /**Obteniendo el bundle con el producto**/
        Bundle objectProduct = getArguments();
        ProductsModel products = null;

        if (objectProduct != null){
            products = (ProductsModel) objectProduct.getSerializable("objeto");
            imageDetail.setImageResource(products.getProductImage());
            nameDetail.setText(products.getProductName());
            priceDetail.setText(products.getProductPrice());
            descDetail.setText(products.getProductDescription());
        }

        return v;
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.decrease:
                countDE(v);
                break;
            case R.id.increase:
                countIN(v);
                break;
        }
    }

    public void countIN(View v) {
        counter++;
        cant_product.setText(Integer.toString(counter));
    }

    public void countDE(View v){
        if (counter == 1){

        }else{
            counter = counter - 1;
            cant_product.setText(Integer.toString(counter));
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                getActivity().onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}
