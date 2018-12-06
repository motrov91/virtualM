package com.example.ingmanuel.mercaexpress.Adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import com.example.ingmanuel.mercaexpress.Fragments.Categories.AseoFragment;
import com.example.ingmanuel.mercaexpress.Fragments.Categories.LacteosFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        Fragment fragment = null;
        switch (i){
            case 0:
                fragment = new LacteosFragment();
                break;
            case 1:
                fragment = new AseoFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch(position){
            case 0:
                return "Lacteos";
            case 1:
                return "Aseo";
        }

        return null;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);

        Log.i("destroy", "destroyItem() [position: "+position +"]" + " childCount" + container.getChildCount());
    }
}
