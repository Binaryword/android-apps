package com.example.custumalertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void clickMe(View view) {

        CustomAlertDailog customAlertDailog = new CustomAlertDailog();
        customAlertDailog.show(getSupportFragmentManager() , "Alert");
    }
}
