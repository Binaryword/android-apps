package com.example.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username , password ;
    SharedPrefrenceSetting mSharedPrefrenceSetting ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username_id) ;
        password = findViewById(R.id.password_id);
        mSharedPrefrenceSetting = new SharedPrefrenceSetting(getApplicationContext());
        Log.d("login_status",String.valueOf(mSharedPrefrenceSetting.readLoginStatus())) ;

        if(mSharedPrefrenceSetting.readLoginStatus()){
            startActivity(new Intent(this , SuccessActivity.class));
            finish();
        }

    }

    public void activateLogin(View view) {

        if(getResources().getString(R.string.username).equals(username.getText().toString()) && getResources().getString(R.string.password).equals(password.getText().toString())){

            startActivity(new Intent(this , SuccessActivity.class));
            mSharedPrefrenceSetting.writeLoginStatus(true);
            finish();

        }// end of if ...
        else{

            Toast.makeText(this, "Login failed try again.." , Toast.LENGTH_SHORT).show();
            username.setText("");
            password.setText("");
        }

    }// end of method..



}
