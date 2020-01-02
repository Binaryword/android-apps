package com.example.dialogitemcheckable;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class MyDialogCheckeable extends DialogFragment {

    ArrayList<String> mySelectedList ;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        mySelectedList = new ArrayList<>();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Select color");

        builder.setMultiChoiceItems(R.array.color, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                String[] items = getActivity().getResources().getStringArray(R.array.color);

                // if  item selected
                if(b)
                {
                    mySelectedList.add(items[i]);
                }
                // if item is deselected....
                else if(mySelectedList.contains(items[i]))
                {
                    mySelectedList.remove(items[i]);

                }

            }
        });


        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                StringBuilder builder1 = new StringBuilder();

                for(String item: mySelectedList){

                    builder1.append(item).append("\n");

                }//end of for loops....

                Toast.makeText(getActivity() , builder1.toString() , Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        return builder.create() ;
    }
}
