package com.example.dialogitemcheckable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialog(View view) {

        MyDialogCheckeable myDialogCheckeable = new MyDialogCheckeable() ;
        myDialogCheckeable.show(getSupportFragmentManager(), "Dailog");

    }


}
