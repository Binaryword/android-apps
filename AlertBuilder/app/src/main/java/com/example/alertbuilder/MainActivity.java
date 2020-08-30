package com.example.alertbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showAlert(View view) {

        AlertFragment alertFragment = new AlertFragment();
        alertFragment.show(getSupportFragmentManager() , "alert");
    }
}
