package com.example.actionmodewitharrayadapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.net.ContentHandler;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<String> {

    List<String> colors = new ArrayList<>();
    Context context ;

    MyAdapter(List<String> color , Context context){
        super(context ,R.layout.item_layout , color);
        this.context = context ;
        this.colors = color ;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater() ;
        View view = layoutInflater.inflate(R.layout.item_layout , parent , false);
        TextView textView = view.findViewById(R.id.id_itemHolder);
        final CheckBox checkBox = view.findViewById(R.id.id_checkHolder);
        textView.setText(colors.get(position));

        // setting the recycler position for checkbox via checkbox tag....
        checkBox.setTag(position);

        // if statement to check if the action mode as been activated from main activity....
        if(MainActivity.isActionMode)
        {
            checkBox.setVisibility(View.VISIBLE);
        }else{

            checkBox.setVisibility(View.INVISIBLE);
        }


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                int position = (int)checkBox.getTag();

                if(MainActivity.selectionList.contains(colors.get(position)))
                {
                    MainActivity.selectionList.remove(colors.get(position));
                }else{

                    MainActivity.selectionList.add(colors.get(position));

                }// end of if else statement....

                MainActivity.sActionMode.setTitle(MainActivity.selectionList.size()+ " Item Selected.." );
            }
        });


        return view ;
    }





    public void deleteColor(List<String> deletList)
    {
        for(String l : deletList){
            colors.remove(l);
        }

        notifyDataSetChanged();

    }
}
