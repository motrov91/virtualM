package com.example.ingmanuel.mercaexpress.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


import com.example.ingmanuel.mercaexpress.Adapters.ProductsAdapter;
import com.example.ingmanuel.mercaexpress.Adapters.ViewPagerAdapter;
import com.example.ingmanuel.mercaexpress.R;


public class InicioFragment extends Fragment{


    private Toolbar toolbar;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private TabLayout tabLayout;
    private EditText toolbarSearch;
    private String textoGuardado;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public InicioFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static InicioFragment newInstance(String param1, String param2) {
        InicioFragment fragment = new InicioFragment();
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
        this.adapter = new ViewPagerAdapter(getChildFragmentManager());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_inicio, container, false);


        viewPager = v.findViewById(R.id.pager);
        //adapter = new ViewPagerAdapter(((AppCompatActivity)getActivity()).getSupportFragmentManager());
        //El getChildFragmentManager permite cargar los datos otra vez al momento de volver al fragment anterior
        adapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout = v.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        toolbar = v.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

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


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putString("contenido", textoGuardado);
    }


}
