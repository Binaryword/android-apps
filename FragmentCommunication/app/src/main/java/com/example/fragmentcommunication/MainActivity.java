package com.example.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MessageFragment.OnSendMessageRequest {

    private TextView displayText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.container_id) !=null){

            if(savedInstanceState  != null)
                return ;

            FragmentManager fragmentManager = getSupportFragmentManager() ;
            FragmentTransaction fragTran = fragmentManager.beginTransaction() ;
            MessageFragment messageFragment = new MessageFragment() ;
            fragTran.add(R.id.container_id , messageFragment ,null).commit();


        }
    }

    @Override
    public void sendMessage(String message) {
        displayText = findViewById(R.id.show_message_id);
        displayText.setText(message);
    }// end of method
}
