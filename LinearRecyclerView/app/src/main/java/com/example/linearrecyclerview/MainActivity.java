package com.example.linearrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;

public class MainActivity extends AppCompatActivity {


    RecyclerView mRecyclerView ;
    RecyclerView.LayoutManager mLayoutManager ;
    StateAdapter mStateAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view_id);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        List<String> stateList = asList(getResources().getStringArray(R.array.places));
        mStateAdapter = new StateAdapter(stateList);
        mRecyclerView.setAdapter(mStateAdapter);

    }
}
