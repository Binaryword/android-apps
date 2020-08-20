package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnMenuButtonSelectListener {

    public static FragmentManager sFragmentManager ;
    public static ContactDbHelper  sContactDbHelper ;
    public static ContactDatabase sContactDatabase ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.mainFrame_container_id) != null)
        {

            if(savedInstanceState != null)
                return ;

            sContactDbHelper = new ContactDbHelper(getApplicationContext());
            sFragmentManager = getSupportFragmentManager();
            sFragmentManager.beginTransaction().add(R.id.mainFrame_container_id , new HomeFragment() , null).commit();
            sContactDatabase = Room.databaseBuilder(this , ContactDatabase.class , "contact_db").allowMainThreadQueries().build();


        }// end of if

    }

    @Override
    public void menuSelectOpetion(int index) {

        switch (index)
        {
            case 0:
                sFragmentManager.beginTransaction().replace(R.id.mainFrame_container_id , new AddContactFragment() , null).addToBackStack(null).commit();
                break;
            case 1:
                sFragmentManager.beginTransaction().replace(R.id.mainFrame_container_id , new ReadContactFragment() , null).addToBackStack(null).commit();
                break;
            case 2:
                sFragmentManager.beginTransaction().replace(R.id.mainFrame_container_id , new UpdateFragement() , null).addToBackStack(null).commit();
                break;
            case 3:
                sFragmentManager.beginTransaction().replace(R.id.mainFrame_container_id , new DeleteFragment() , null).addToBackStack(null).commit();
                break;
        }

    }
}
