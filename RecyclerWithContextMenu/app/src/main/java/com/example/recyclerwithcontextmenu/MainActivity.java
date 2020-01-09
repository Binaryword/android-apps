package com.example.recyclerwithcontextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {


    RecyclerView mRecyclerView  ;
    List<Thing> mThings ;
    private  int[] image_ids  = {R.drawable.baby ,
    R.drawable.box ,
    R.drawable.cup ,
    R.drawable.grape,
    R.drawable.logo,
    R.drawable.phone,
    R.drawable.pot,
    R.drawable.quran,
    R.drawable.tedy,
    R.drawable.umbrella};
    String thing_name[] ;
    MyAdapter mMyAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        thing_name = getResources().getStringArray(R.array.string_image_name);
        mThings = new ArrayList<>();
        mRecyclerView = findViewById(R.id.id_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        loadThings();
        mMyAdapter = new MyAdapter(mThings);
        mRecyclerView.setAdapter(mMyAdapter);


    }// end of oncreate method


    public void loadThings(){

        int pos = 0 ;

        for(String name : thing_name)
        {
            Thing thing = new Thing(image_ids[pos] , name) ;
            mThings.add(thing);
            pos++ ;
        }// end of for loop...

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case 121:
                showMessage("item added");

                return true ;
            case 122:
                showMessage("item deleted");
                mMyAdapter.removeItem(item.getGroupId());
                return true ;

                default:
                    return super.onContextItemSelected(item);

        }

    }


    public void showMessage(String message)
    {

        Snackbar snackbar = Snackbar.make(findViewById(R.id.id_snack_bar_parent) , message , Snackbar.LENGTH_LONG) ;
        snackbar.show();
    }
}
