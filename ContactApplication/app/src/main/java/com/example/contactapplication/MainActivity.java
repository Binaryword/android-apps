package com.example.contactapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText txtUserName , txtPassword ;
    private Button loginButton, registerButton ;
    public static ContactAppConfig mContactAppConfig ;
    public static AppDatabase sAppDatabase ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        initializeWidget();
        mContactAppConfig = new ContactAppConfig(getApplicationContext());
        sAppDatabase = Room.databaseBuilder(getApplicationContext() , AppDatabase.class , "userdb").build() ;

        // check if user as already login.......
        if(mContactAppConfig.readPreference())
        {
            startActivity(new Intent(this , HomeActivity.class));
        }//end of if

    }


    public void initializeWidget(){

        txtUserName = findViewById(R.id.id_username) ;
        txtPassword = findViewById(R.id.id_password) ;
        loginButton = findViewById(R.id.id_login) ;
        registerButton = findViewById(R.id.id_registerButton) ;


    }


    // response to the click event of loginButton..
    public void loginAction(View view) {

        String username = txtUserName.getText().toString() ;
        String password = txtPassword.getText().toString() ;




            if(username.equals(getResources().getString(R.string.res_myusername)) && password.equals(getResources().getString(R.string.res_mypassword)))
            {
                //update the login preference
                mContactAppConfig.writePreference(true);
                Intent intent = new Intent(MainActivity.this , HomeActivity.class) ;
                startActivity(intent);
                finish();
            }
            else{

                Toast.makeText(getApplicationContext() , "rong credentials" , Toast.LENGTH_SHORT).show();
                //clearCredientialField();
            }


    }// end of login action

    public void clearCredientialField(){

        txtUserName.setText("");
        txtPassword.setText("");
    }

    //the response to the registration click event
    public void registerAction(View view) {

        startActivity(new Intent(this , RegisterActivity.class));
    }
}
