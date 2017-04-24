package com.ayurvihar.somaiya.ayurvihar.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ayurvihar.somaiya.ayurvihar.Activity.Under5.Under5_Core;
import com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions.BackgroundTaskCR;
import com.ayurvihar.somaiya.ayurvihar.R;

/**
 * Created by ABC on 23-Apr-17.
 */

public class Tab1 extends Fragment {

    EditText Addn1 , Addn2 , Addn3 , Addn4 , Addn5 , Addn6 , Addn7 , Addn8 , Addn9;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        //Inflate the view for this fragment
        View view=inflater.inflate(R.layout.tab1_child_data,container,false);

        Addn1 = (EditText) view.findViewById(R.id.Addn1);
        Addn2 = (EditText) view.findViewById(R.id.Addn2);
        Addn3 = (EditText) view.findViewById(R.id.Addn3);
        Addn4 = (EditText) view.findViewById(R.id.Addn4);
        Addn5 = (EditText) view.findViewById(R.id.Addn5);
        Addn6 = (EditText) view.findViewById(R.id.Addn6);
        Addn7 = (EditText) view.findViewById(R.id.Addn7);
        Addn8 = (EditText) view.findViewById(R.id.Addn8);
        Addn9 = (EditText) view.findViewById(R.id.Addn9);

        Addn1.setText(Under5_Core.childidentifier);
        Addn2.setText(Under5_Core.familyidentifier);
        Addn3.setText(Under5_Core.address);
        Addn4.setText(Under5_Core.mobilenumber);
        Addn5.setText(Under5_Core.childname);
        Addn6.setText(Under5_Core.fathername);
        Addn7.setText(Under5_Core.mothername);
        Addn8.setText(Under5_Core.dob);
        Addn9.setText(Under5_Core.sex);

        Button update = (Button) view.findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundTaskCR backgroundTaskCR = new BackgroundTaskCR(Under5_Scroll_View.ctx , Under5_Scroll_View.dialog , Under5_Scroll_View.SV);
                backgroundTaskCR.execute("Update" , Addn1.getText().toString(),
                        Addn2.getText().toString(),
                        Addn3.getText().toString(),
                        Addn4.getText().toString(),
                        Addn5.getText().toString(),
                        Addn6.getText().toString(),
                        Addn7.getText().toString(),
                        Addn8.getText().toString(),
                        Addn9.getText().toString() );

            }
        });
                return view;
    }
}