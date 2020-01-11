package com.example.actionmodewitharrayadapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
        textView.setText(colors.get(position));

        return view ;
    }
}
