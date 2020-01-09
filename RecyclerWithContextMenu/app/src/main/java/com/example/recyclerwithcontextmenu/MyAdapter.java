package com.example.recyclerwithcontextmenu;


import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    List<Thing> itemsList ;

    MyAdapter(List<Thing> itemsList)
    {
        this.itemsList = itemsList ;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_content , parent , false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.mImageView.setImageResource(itemsList.get(position).getThing_id());
        holder.mTextView.setText(itemsList.get(position).getThing_name());

    }

    @Override
    public int getItemCount() {

        return itemsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{

        ImageView mImageView ;
        TextView mTextView ;
        CardView mCardView ;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.id_imageHolder);
            mTextView = itemView.findViewById(R.id.id_textHolder);
            mCardView = itemView.findViewById(R.id.id_carview);
            mCardView.setOnCreateContextMenuListener(this);

        }// end of constructor....

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle("Header Text");
            contextMenu.add(this.getAdapterPosition() , 121 , 0 , "add Items");
            contextMenu.add(this.getAdapterPosition() , 122 , 1 , "Delete Items" );
        }
    }// end of class


    public void removeItem(int itemId){

        itemsList.remove(itemId);
        notifyDataSetChanged();

    }// end of custom method to remove item
}
