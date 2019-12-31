package com.example.snackbardemo;

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

    public void showSnack(View view) {

        Snackbar snackbar = Snackbar.make(findViewById(R.id.id_roolLayout) , "1 item removed" , Snackbar.LENGTH_LONG) ;
        snackbar.setAction("UNDO", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext() , "undo clicked" , Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.show(); ;

    }
}
