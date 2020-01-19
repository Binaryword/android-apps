package com.example.highqualitycamapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    String currentImageDir= null ;
    private static int IMAGE_REQUEST_CODE = 101 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void captureImage(View view) {

        Intent image_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(image_intent.resolveActivity(getPackageManager()) != null){

            File file = null ;

            try {

                file = getImageFile() ;

            } catch (IOException e) {
                e.printStackTrace();

            }// end of try catch statement....

            if(file != null)
            {

                Uri imageUri = FileProvider.getUriForFile(this , "com.example.android.provider" , file);
                image_intent.putExtra(MediaStore.EXTRA_OUTPUT , imageUri);
                startActivityForResult(image_intent , IMAGE_REQUEST_CODE );

            }// end of if ....
        }

    }

    public void displayImage(View view) {

        Intent intent =  new Intent(getApplicationContext() , DisplayImage.class);
        intent.putExtra("image_path" , currentImageDir ) ;
        startActivity(intent);
    }

    public File getImageFile() throws IOException {

        String timestamp = new SimpleDateFormat("yyyMMdd_HHmmss").format(new Date()) ;
        String imageName = "jpg_" + timestamp  ;
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imageFile = File.createTempFile(imageName , ".jpg", storageDir) ;
        currentImageDir = imageFile.getAbsolutePath() ;

        return imageFile ;
    }
}
