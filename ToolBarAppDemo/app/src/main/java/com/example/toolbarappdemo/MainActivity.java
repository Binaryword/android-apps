package com.example.toolbarappdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toolbar_id);
        setSupportActionBar(mToolbar);
       /* ActionBar actionBar = getSupportActionBar() ;
        actionBar.setDisplayHomeAsUpEnabled(true);*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuItem = getMenuInflater() ;
        menuItem.inflate(R.menu.main_menu_item , menu);

        MenuItem.OnActionExpandListener onActionExpandListener = new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {

                Toast.makeText(getApplicationContext() , "Search expanded" , Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                Toast.makeText(getApplicationContext() , "Collapse Search" , Toast.LENGTH_SHORT).show();
                return true;
            }
        };

        MenuItem m = menu.findItem(R.id.search_menu_id);
        m.setOnActionExpandListener(onActionExpandListener);
        return true ;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.search_menu_id :
                Toast.makeText(this , "Search icon clicked.." , Toast.LENGTH_SHORT).show();
                return true;

            case R.id.share_menu_id :
                Toast.makeText(this , "Share icon clicked " , Toast.LENGTH_SHORT).show();
                return  true ;

                default:
                    return super.onOptionsItemSelected(item);

        }

    }
}
