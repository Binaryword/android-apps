package com.example.swipeviewapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SwipeAdapter extends FragmentStatePagerAdapter {
    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        MessageFrag messageFrag = new MessageFrag();
        Bundle bundle = new Bundle();
        position = position +1 ;
        bundle.putString("message" , "Page " + position );
        messageFrag.setArguments(bundle);
        return messageFrag;
    }

    @Override
    public int getCount() {
        return 100;
    }
}
