package com.example.toolbardemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.id_toolbarapp) ;
        setSupportActionBar(mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater() ;
        menuInflater.inflate(R.menu.app_menu_file , menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // checking which item was selected..
        switch (item.getItemId())
        {
            case R.id.menu_search :
                Toast.makeText(this , "Search clicked" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_folder :
                Toast.makeText(this, "folder clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_share :
                Toast.makeText(this , "share clicked" , Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
