package com.example.recyclerfilterapp;

import androidx.annotation.NonNull;
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

import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    Toolbar toolbar  ;
    RecyclerView mRecyclerView ;
    RecyclerView.LayoutManager layoutManager ;

    ArrayList<Contact> contactList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactList.add(new Contact("akintunde", "07035342756")) ;
        contactList.add(new Contact("bolanle", "07035342756"));
                contactList.add(new Contact("olajide", "07035342756"));
                        contactList.add(new Contact("oyindamola", "07035342756"));
                                contactList.add( new Contact("akolawole", "07035342756"));
                                        contactList.add(new Contact("minirudeen", "07035342756"));
                                                contactList.add(new Contact("sholape", "07035342756"));
                                                        contactList.add(new Contact("ahemdi", "07035342756"));
                                                                contactList.add(new Contact("lanrewaju", "07035342756"));
                                                                        contactList.add(new Contact("obolade", "07035342756"));
                                                                                contactList.add(new Contact("kehinde", "07035342756"));



        toolbar = findViewById(R.id.id_tool_bar) ;
        mRecyclerView = findViewById(R.id.id_recyclerview);
        layoutManager = new LinearLayoutManager(getApplicationContext());

        ContactAdapter contactAdapter = new ContactAdapter(contactList);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(contactAdapter);
        mRecyclerView.setHasFixedSize(true);
        setSupportActionBar(toolbar);

     //   ActionBar actionBar = getSupportActionBar() ;
       // actionBar.setDisplayShowHomeEnabled(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater() ;
        menuInflater.inflate(R.menu.menu_tool , menu);

        MenuItem.OnActionExpandListener onActionExpandListener = new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {

                Toast.makeText(getApplicationContext() , "search field expanded" , Toast.LENGTH_SHORT ).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                Toast.makeText(getApplicationContext() , "search field collapsed" , Toast.LENGTH_SHORT ).show();
                return true;
            }
        };

        MenuItem searchItem = menu.findItem(R.id.id_menu_search);
        SearchView searchView = (SearchView) searchItem.getActionView() ;
        searchView.setOnQueryTextListener(this);
        searchItem.setOnActionExpandListener(onActionExpandListener);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        Toast.makeText(getApplicationContext() , "user typing text" , Toast.LENGTH_SHORT).show();
        return true;
    }
}
