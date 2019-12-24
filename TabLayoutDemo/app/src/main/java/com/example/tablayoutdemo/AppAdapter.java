package com.example.tablayoutdemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class AppAdapter extends FragmentPagerAdapter {


    public AppAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        FragContentDisplay fragContentDisplay = new FragContentDisplay();
        Bundle bundle = new Bundle();
        position = position + 1 ;
        bundle.putString("message" , "page: " + position);
        fragContentDisplay.setArguments(bundle);
        return fragContentDisplay;
    }

    @Override
    public int getCount(){
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        position = position + 1 ;
        return  "Page" + position ;
    }
}
