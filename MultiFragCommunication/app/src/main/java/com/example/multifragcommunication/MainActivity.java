package com.example.multifragcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements MessageFragment.OnSentMessageListener {


     FragmentManager mFragmentManager ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.frame_container_id)!=null){

            if(savedInstanceState != null)
                return ;

            mFragmentManager = getSupportFragmentManager() ;
            mFragmentManager.beginTransaction().add(R.id.frame_container_id , new MessageFragment() , null).commit() ;

        }


    }// end of on create method.

    @Override
    public void onSendMessage(String message) {
        Bundle bundle = new Bundle();
        bundle.putString("MESSAGE" , message);
        DisplayFragment displayFragment = new DisplayFragment() ;
        displayFragment.setArguments(bundle);
        mFragmentManager.beginTransaction().replace(R.id.frame_container_id , displayFragment , null).addToBackStack(null).commit();

    }
}
