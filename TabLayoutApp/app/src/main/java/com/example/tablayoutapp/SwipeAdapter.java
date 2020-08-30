package com.example.tablayoutapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SwipeAdapter extends FragmentPagerAdapter {
    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        FragController fragController = new FragController();
        Bundle bundle = new Bundle();
        position++;
        bundle.putString("message" , "Frag " + position);
        fragController.setArguments(bundle);

        return fragController;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        position++;
        return "page "+ position;
    }
}
