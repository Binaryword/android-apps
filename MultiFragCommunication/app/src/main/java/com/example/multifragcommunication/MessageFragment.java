package com.example.multifragcommunication;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    Button button ;
    EditText mEditText ;
    OnSentMessageListener mOnSentMessageListener ;

    public MessageFragment() {
        // Required empty public constructor
    }

    public interface OnSentMessageListener{

        public void onSendMessage(String message);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        button = view.findViewById(R.id.send_button_id);
        mEditText = view.findViewById(R.id.edit_text_id);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = mEditText.getText().toString() ;
                mOnSentMessageListener.onSendMessage(message);
            }
        });

        return view ;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity)context ;

        try {
            mOnSentMessageListener = (OnSentMessageListener) activity ;
        }catch (ClassCastException ex)
        {
            throw new ClassCastException(activity.toString() + " Did not implement OnSendMessageListener");
        }// end of try catch..
    }

    @Override
    public void onResume() {
        super.onResume();
        mEditText.setText("");
    }
}
