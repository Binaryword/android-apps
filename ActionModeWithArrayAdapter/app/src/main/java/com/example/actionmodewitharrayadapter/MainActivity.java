package com.example.actionmodewitharrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> colors  ;
    MyAdapter mMyAdapter ;
    ListView mListView ;
    List<String> selectionList  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.id_listView);
        mListView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        mListView.setMultiChoiceModeListener(mMultiChoiceModeListener);
        List<String> list = getColorList() ;
        Toast.makeText(this , list.size()+"" , Toast.LENGTH_LONG).show();
        mMyAdapter = new MyAdapter(list , this);
        mListView.setAdapter(mMyAdapter);

    }


    public List<String> getColorList(){

        colors = new ArrayList<>();
        colors.addAll(Arrays.asList(getResources().getStringArray(R.array.colors)));
        return colors ;
    }

    AbsListView.MultiChoiceModeListener mMultiChoiceModeListener = new AbsListView.MultiChoiceModeListener() {
        @Override
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {

            if(selectionList.contains(colors.get(i)))
                selectionList.remove(colors.get(i));
            else
                selectionList.add(colors.get(i));

            actionMode.setTitle(selectionList.size() + " item selected..");
        }

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {

            MenuInflater menuInflater = actionMode.getMenuInflater() ;
            menuInflater.inflate(R.menu.action_mode_menu , menu);

            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch(menuItem.getItemId()){
                case R.id.id_delete_menu :
                    mMyAdapter.deleteColor(selectionList);
                    actionMode.finish();
                    return true ;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
                selectionList.clear();
        }
    };
}
