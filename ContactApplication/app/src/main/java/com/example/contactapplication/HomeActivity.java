package com.example.contactapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private Button mLogoutButton  ;
    private TextView mUserInfo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        mLogoutButton = findViewById(R.id.id_logout) ;
        mUserInfo = findViewById(R.id.id_UserInfo);

//        List<User> userList = MainActivity.sAppDatabase.mUserDao().getUsers();
//
//        for(User user: userList){
//
//            String name = user.getUsername() ;
//            String mail = user.getMail() ;
//            String password = user.getPassword();
//
//            mUserInfo.setText("Name :" + name +  "\n" +
//                    "Password: " + password + "\n" +
//                    "Email : " + mail );
//
//        }

        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this , MainActivity.class);
                startActivity(intent);
                MainActivity.mContactAppConfig.writePreference(false);
                finish();
            }
        });
    }
}
