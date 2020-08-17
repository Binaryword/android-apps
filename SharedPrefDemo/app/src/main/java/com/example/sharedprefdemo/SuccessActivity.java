package com.example.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SuccessActivity extends AppCompatActivity {

    SharedPrefrenceSetting sharedPrefrenceSetting ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        sharedPrefrenceSetting = new SharedPrefrenceSetting(getApplicationContext());
    }


    public void activateLogout(View view) {
        sharedPrefrenceSetting.writeLoginStatus(false);
        startActivity(new Intent(this , MainActivity.class));

        finish();
    }
}
