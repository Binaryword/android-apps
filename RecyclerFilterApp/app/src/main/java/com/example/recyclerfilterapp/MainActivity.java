package com.example.recyclerfilterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.id_tool_bar) ;
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
        searchItem.setOnActionExpandListener(onActionExpandListener);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        return super.onOptionsItemSelected(item);
    }
}
