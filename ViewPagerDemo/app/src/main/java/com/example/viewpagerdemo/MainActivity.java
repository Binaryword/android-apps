package com.example.viewpagerdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
;

public class MainActivity extends AppCompatActivity {

    ViewPager mViewPager  ;
    MessageStateAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.id_viewPager);
        adapter = new MessageStateAdapter(getSupportFragmentManager(), 1);
        mViewPager.setAdapter(adapter);

    }
}
