package com.example.swipeviewapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFrag extends Fragment {

    TextView mTextView ;
    public MessageFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        mTextView = view.findViewById(R.id.show_message_id);
        String messsage = getArguments().getString("message");
        mTextView.setText(messsage);
        return view ;
    }

}
