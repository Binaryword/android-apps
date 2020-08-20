package com.example.linearrecyclerview;

import android.icu.text.LocaleDisplayNames;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;


public class StateAdapter extends RecyclerView.Adapter<StateAdapter.StateViewHolder> {


    private List<String> itemList ;

    public StateAdapter(List<String> itemList){

        this.itemList = itemList ;
    }

    @NonNull
    @Override
    public StateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate( R.layout.state_holder_layout, parent , false) ;
        Log.d("CHECKING ERRORS" , textView.toString());
        StateViewHolder stateViewHolder = new StateViewHolder(textView);

        return stateViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StateViewHolder holder, int position) {

        holder.mTextView.setText(itemList.get(position));
    }

    @Override
    public int getItemCount() {

        return itemList.size();
    }

    public class StateViewHolder extends RecyclerView.ViewHolder{

        TextView mTextView ;
        public StateViewHolder(@NonNull TextView itemView) {
            super(itemView);
            mTextView = itemView ;
        }
    }
}
