package com.example.camapponedemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView mImageView ;
    private  static int IMAGE_REQUEST_CODE  = 101 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.id_image_holder);
    }

    public void capture_image(View view) {

        Intent image_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if( image_intent.resolveActivity(getPackageManager()) != null )
        {
            startActivityForResult(image_intent , IMAGE_REQUEST_CODE);
        }


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){

            Bundle bundle = data.getExtras();
            Bitmap image_bitmap = (Bitmap) bundle.get("data");
            mImageView.setImageBitmap(image_bitmap);

        }





    }
}
