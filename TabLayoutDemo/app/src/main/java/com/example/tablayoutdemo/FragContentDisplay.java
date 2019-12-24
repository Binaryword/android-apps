package com.example.tablayoutdemo;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragContentDisplay extends Fragment {

    TextView mTextView ;
    public FragContentDisplay() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_frag_content_display, container, false);
        mTextView = view.findViewById(R.id.id_text);
        mTextView.setText(getArguments().getString("message"));
        return  view ;
    }

}
