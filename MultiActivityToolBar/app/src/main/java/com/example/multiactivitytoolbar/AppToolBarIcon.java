package com.example.multiactivitytoolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AppToolBarIcon extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.general_menu , menu);

        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.id_search :
                showmessage("search icon");
                return true ;
            case R.id.id_message :
                showmessage("messsage icon");
                return true ;

        }

        return super.onOptionsItemSelected(item);
    }


    public void showmessage(String message){

        Toast.makeText(getApplicationContext() , message , Toast.LENGTH_SHORT).show();
    }
}
