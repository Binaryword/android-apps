package com.example.viewpagerdemo;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFrag extends Fragment {

    EditText mEditText  ;
    public MessageFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_message, container, false);
        mEditText = view.findViewById(R.id.id_message);
        String text = getArguments().getString("message") ;
        mEditText.setText(text);
        return view ;
    }


}
