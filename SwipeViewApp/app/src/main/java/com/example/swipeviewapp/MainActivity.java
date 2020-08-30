package com.example.swipeviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    ViewPager mViewPager ;
    SwipeAdapter mSwipeAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.pager);
        mSwipeAdapter = new SwipeAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSwipeAdapter);

    }
}
