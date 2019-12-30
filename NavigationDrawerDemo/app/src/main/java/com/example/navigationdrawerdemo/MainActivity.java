package com.example.navigationdrawerdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar ;
    DrawerLayout mDrawerLayout ;
    NavigationView mNavigationView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.id_tool_bar);
        setSupportActionBar(mToolbar);

        final ActionBar anctionBar = getSupportActionBar();
        anctionBar.setDisplayHomeAsUpEnabled(true);
        anctionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        mDrawerLayout = findViewById(R.id.id_drawerLayout);
        mNavigationView = findViewById(R.id.id_navDrawer);



        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Log.d("show" , "listener method callde") ;
                switch(menuItem.getItemId())
                {
                    case R.id.id_menu_cammera :
                        menuItem.setCheckable(true) ;
                        showMessage("cammera clicked");
                        mDrawerLayout.closeDrawers();
                        return true ;

                    case R.id.id_menu_driveFile :
                        menuItem.setCheckable(true) ;
                        showMessage("new file clicked");
                        mDrawerLayout.closeDrawers();
                        return true ;

                    case R.id.id_menu_security :
                        menuItem.setCheckable(true) ;
                        showMessage("security clicked");
                        mDrawerLayout.closeDrawers();
                        return true ;

                    case R.id.id_menu_setting :
                        menuItem.setCheckable(true) ;
                        showMessage("setting clicked");
                        mDrawerLayout.closeDrawers();
                        return true ;


                } // end of switch statement


                Toast.makeText(getApplicationContext() , "app started" , Toast.LENGTH_SHORT).show();
                return  false ;

            }
        });//end of listeners.....

    }


    public void showMessage(String message){

        Toast.makeText(getApplicationContext() , message , Toast.LENGTH_SHORT).show();

    }// end show message.......
}
