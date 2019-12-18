package com.example.recyclerfilterapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyContactViewHolder> {

    List<Contact> mContactList ;

    public ContactAdapter(List<Contact> contactList){
        this.mContactList = contactList ;
    }

    @NonNull
    @Override
    public  MyContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.content_layout , parent , false);
        MyContactViewHolder myContactViewHolder = new MyContactViewHolder(view);

        return myContactViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyContactViewHolder holder, int position) {

        String name = mContactList.get(position).getContact_name() ;
        String number = mContactList.get(position).getContact_number() ;

        holder.name_textView.setText(name);
        holder.number_textView.setText(number);

    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }

    public class MyContactViewHolder extends RecyclerView.ViewHolder{

        TextView name_textView ;
        TextView number_textView ;
        public MyContactViewHolder(@NonNull View itemView) {
            super(itemView);

            name_textView = itemView.findViewById(R.id.id_name_holder);
            number_textView = itemView.findViewById(R.id.id_number_holder);

        }
    }
}
