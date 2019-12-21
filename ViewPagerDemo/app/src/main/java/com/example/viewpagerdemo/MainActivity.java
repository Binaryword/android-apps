package com.example.viewpagerdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager mViewPager  ;
    MessageStateAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.id_viewPager);
        adapter = new MessageStateAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);

    }
}
