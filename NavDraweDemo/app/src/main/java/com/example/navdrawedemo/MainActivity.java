package com.example.navdrawedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {


    Toolbar mToolbar ;
    NavigationView mNavigationView ;
    DrawerLayout mDrawerLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mToolbar = findViewById(R.id.toolbar_id);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar() ;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        mDrawerLayout = findViewById(R.id.drawer_id);

        mNavigationView = findViewById(R.id.navView_id);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch(menuItem.getItemId())
                {
                    case R.id.contact_menu_id :
                        showMenuAction("Contact...");
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return  true ;
                    case R.id.setting_menu_id :
                        showMenuAction("Settings...");
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true ;
                    case R.id.synco_menu_id :
                        showMenuAction("Synchronize...");
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true ;
                    case R.id.update_menu_id :
                        showMenuAction("Update...");
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();

                        return true ;
                }

                return false ;
            }
        });






    }


    public void showMenuAction(String message){

        Toast.makeText(this, message , Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case android.R.id.home :
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true ;
        }

        return super.onOptionsItemSelected(item);
    }
}
