package com.example.actionmodedemoone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mButton ;
    ActionMode mActionMode ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.id_button);

        mButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                if(mActionMode != null){
                    return false ;
                }

                mActionMode = startActionMode(callback);

                return true;
            }
        });



    }


    private ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {

            MenuInflater menuInflater = actionMode.getMenuInflater() ;
            menuInflater.inflate(R.menu.menu_list_layout , menu);

            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {




            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {

            mActionMode = null ;
        }
    } ;



}
