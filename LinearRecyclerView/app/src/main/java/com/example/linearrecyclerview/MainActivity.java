package com.example.linearrecyclerview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {


    RecyclerView mRecyclerView ;
    RecyclerView.LayoutManager mLayoutManager ;
    StateAdapter mStateAdapter ;
    Toolbar mToolbar;
    List<String> stateList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.app_toolbar_id);
        setSupportActionBar(mToolbar);
        mRecyclerView = findViewById(R.id.recycler_view_id);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        stateList = asList(getResources().getStringArray(R.array.places));
        mStateAdapter = new StateAdapter(stateList);
        mRecyclerView.setAdapter(mStateAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater() ;
        menuInflater.inflate(R.menu.app_main_menu , menu);

        MenuItem menuItem = menu.findItem(R.id.search_icon_id) ;
        SearchView searchView = (SearchView) menuItem.getActionView() ;
        searchView.setOnQueryTextListener(this);
        return true ;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        List<String> newList = new ArrayList<>();

        for(String text : stateList )
        {
            if(text.toLowerCase().contains(newText.toLowerCase())){

                newList.add(text);
            }

        }// end of for statement

        mStateAdapter.updateView(newList);

        return true ;
    }
}
