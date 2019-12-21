package com.example.viewpagerdemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MessageStateAdapter extends FragmentStatePagerAdapter {


    public MessageStateAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        MessageFrag messageFrag = new MessageFrag();
        position = position + 1 ;
        Bundle bundle = new Bundle();
        bundle.putString("message" , " PAGE : "+position);
        messageFrag.setArguments(bundle);
        return messageFrag ;
    }

    @Override
    public int getCount() {

        return 100;
    }
}
