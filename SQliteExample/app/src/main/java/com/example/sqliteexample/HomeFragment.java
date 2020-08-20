package com.example.sqliteexample;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

     OnMenuButtonSelectListener mOnMenuButtonSelectListener  ;
     Button addButton, readButton, updateButton, deleteButton ;

    public HomeFragment() {
        // Required empty public constructor
    }

    public interface OnMenuButtonSelectListener{

        public void menuSelectOpetion(int index);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        addButton = view.findViewById(R.id.menu_button_add_id);
        readButton = view.findViewById(R.id.menu_button_read_id);
        updateButton = view.findViewById(R.id.menu_button_update_id);
        deleteButton = view.findViewById(R.id.menu_button_delete_id);
        addButton.setOnClickListener(this);
        readButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);

        return view ;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.menu_button_add_id :
                mOnMenuButtonSelectListener.menuSelectOpetion(0);
                break;
            case R.id.menu_button_read_id :
                mOnMenuButtonSelectListener.menuSelectOpetion(1);
                break;
            case R.id.menu_button_update_id :
                mOnMenuButtonSelectListener.menuSelectOpetion(2);
                break;
            case R.id.menu_button_delete_id :
                mOnMenuButtonSelectListener.menuSelectOpetion(3);
                break;

        }// end of switch statement

    }// end of method

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context ;

        try{

            mOnMenuButtonSelectListener = (OnMenuButtonSelectListener) activity ;

        }catch (ClassCastException ex){

            throw new ClassCastException(activity.toString() + "  must implement OnMenuButtonSelectListener") ;

        }// end of try catch
    }
}
