package com.example.ingmanuel.mercaexpress;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.ingmanuel.mercaexpress.Fragments.CarritoFragment;
import com.example.ingmanuel.mercaexpress.Fragments.Categories.AseoFragment;
import com.example.ingmanuel.mercaexpress.Fragments.InicioFragment;
import com.example.ingmanuel.mercaexpress.Fragments.Categories.LacteosFragment;
import com.example.ingmanuel.mercaexpress.Fragments.PerfilFragment;

public class MainActivity extends AppCompatActivity implements InicioFragment.OnFragmentInteractionListener,
    CarritoFragment.OnFragmentInteractionListener, PerfilFragment.OnFragmentInteractionListener, LacteosFragment.OnFragmentInteractionListener,
        AseoFragment.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.FragmentContainer, new InicioFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragmentInicio, fragmentCarrito, fragmentPerfil;

            switch (item.getItemId()) {
                case R.id.nav_home:
                    fragmentInicio = new InicioFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer,fragmentInicio).commit();
                    return true;
                case R.id.nav_cart:
                    fragmentCarrito = new CarritoFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer,fragmentCarrito).commit();
                    return true;
                case R.id.nav_offert:
                    return true;
                case R.id.nav_profile:
                    fragmentPerfil = new PerfilFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer,fragmentPerfil).commit();
                    return true;
            }

            return false;
        }
    };

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
