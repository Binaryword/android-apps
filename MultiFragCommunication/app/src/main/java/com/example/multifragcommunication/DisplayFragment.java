
package com.example.multifragcommunication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DisplayFragment extends Fragment {

    TextView showMessage ;

    public DisplayFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_display , container , false);

        showMessage = view.findViewById(R.id.display_text_id);

        Bundle bundle = getArguments();
        String message = bundle.getString("MESSAGE");
        showMessage.setText(message);

        return view ;
    }
}
