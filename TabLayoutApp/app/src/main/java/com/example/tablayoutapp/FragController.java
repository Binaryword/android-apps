package com.example.tablayoutapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragController extends Fragment {

    TextView mTextView ;
    public FragController() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_controller, container, false);

        mTextView = view.findViewById(R.id.show_text_id);
        mTextView.setText(getArguments().getString("message"));

        return view ;
    }

}
