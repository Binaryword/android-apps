package com.example.gridrecyclerdemoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int[] imageFile = {R.drawable.baby , R.drawable.box , R.drawable.cup , R.drawable.grape ,
    R.drawable.logo , R.drawable.phone , R.drawable.pot , R.drawable.quran , R.drawable.tedy,
    R.drawable.umbrella} ;
    List<String> imageNamesList ;

    RecyclerView mRecyclerView ;
    RecyclerView.LayoutManager mLayoutManager  ;
    ImageAdapter mImageAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = findViewById(R.id.recycler_view_id);
        mLayoutManager = new GridLayoutManager(this , 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        List<String> imageName = Arrays.asList(getResources().getStringArray(R.array.image_name));
        mImageAdapter = new ImageAdapter(imageFile , imageName , getApplicationContext());
        mRecyclerView.setAdapter(mImageAdapter);

    }
}
