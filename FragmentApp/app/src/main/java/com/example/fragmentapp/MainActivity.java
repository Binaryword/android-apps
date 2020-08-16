package com.example.fragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager sFragmentManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(findViewById(R.id.main_container_id) != null)
        {


            if(savedInstanceState != null)
                return ;


            sFragmentManager = getSupportFragmentManager() ;
            FirstFragment firstFragment = new FirstFragment();
            FragmentTransaction fragmentTransaction = sFragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.main_container_id , firstFragment, null).commit();

        } // end of if

    }


}
