package com.example.gridrecyclerdemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        ImageView imageView = findViewById(R.id.big_image_view_id);
        Intent intent = getIntent();
        int imageLoacation = intent.getIntExtra("IMAGE_KEY" ,00);
        imageView.setImageResource(imageLoacation);

    }
}
