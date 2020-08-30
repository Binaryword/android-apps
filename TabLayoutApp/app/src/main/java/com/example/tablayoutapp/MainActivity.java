package com.example.tablayoutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar ;
    ViewPager mViewPager ;
    TabLayout mTabLayout ;
    SwipeAdapter mSwipeAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar_id);
        setSupportActionBar(mToolbar);


       mViewPager = findViewById(R.id.pager);
        mSwipeAdapter = new SwipeAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSwipeAdapter);

        mTabLayout = findViewById(R.id.tab_id);
        mTabLayout.setupWithViewPager(mViewPager);

    }
}
