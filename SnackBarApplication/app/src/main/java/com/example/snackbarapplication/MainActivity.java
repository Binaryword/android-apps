package com.example.snackbarapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showSnackBar(View view) {

        Snackbar snackbar = Snackbar.make(findViewById(R.id.root_layout_id) , "show snack" , Snackbar.LENGTH_LONG);
       snackbar.setAction("UNDO", new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getApplicationContext() , "Clicked" , Toast.LENGTH_SHORT).show();
           }
       });

        snackbar.show();
    }
}
