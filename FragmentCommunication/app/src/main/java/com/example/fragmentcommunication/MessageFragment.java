package com.example.fragmentcommunication;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MessageFragment extends Fragment {


    private Button sendbutton ;
    private EditText textBox  ;
    OnSendMessageRequest mOnSendMessageRequest ;
    public interface OnSendMessageRequest{
        public void sendMessage(String message);
    }

    public MessageFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_message , container , false);

        sendbutton = view.findViewById(R.id.send_button_id) ;
        textBox = view.findViewById(R.id.enter_message_id) ;

        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mOnSendMessageRequest.sendMessage(textBox.getText().toString());
            }
        });


        return view ;
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        Activity activity = (Activity) context;

        try {

            mOnSendMessageRequest = (OnSendMessageRequest)activity ;

        } catch (ClassCastException ex) {

            throw new ClassCastException(activity.toString() + " must implement the OnSendMessageResquet.....");
        }
    }
}
