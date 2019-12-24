 package com.example.tablayoutdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TabWidget;

import com.google.android.material.tabs.TabLayout;

 public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar ;
    AppAdapter mAppAdapter ;
    ViewPager mViewPager ;
    TabLayout mTabLayout  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mToolbar = findViewById(R.id.id_toolbar);
        setSupportActionBar(mToolbar);

        mViewPager = findViewById(R.id.id_viewpager);
        mAppAdapter = new AppAdapter(getSupportFragmentManager() , 1);
        mViewPager.setAdapter(mAppAdapter);


        mTabLayout = findViewById(R.id.id_tablayout);
        mTabLayout.setupWithViewPager(mViewPager);

    }

}
