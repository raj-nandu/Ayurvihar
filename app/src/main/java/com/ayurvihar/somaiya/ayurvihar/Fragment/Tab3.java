package com.ayurvihar.somaiya.ayurvihar.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ayurvihar.somaiya.ayurvihar.Activity.Under5.Under5;
import com.ayurvihar.somaiya.ayurvihar.Activity.Under5.Under5_Core;
import com.ayurvihar.somaiya.ayurvihar.Activity.Under5.Under5_OnePlace;
import com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions.BackgroundTaskHR;
import com.ayurvihar.somaiya.ayurvihar.R;

/**
 * Created by ABC on 23-Apr-17.
 */

public class Tab3 extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    EditText addhl1 , addhl2, addhl3, addhl4, addhl5, addhl6, addhl7, addhl8;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //Inflate the view for this fragment
        View view=inflater.inflate(R.layout.tab3_health_checkup,container,false);
        //Button Add = (Button)view.findViewById(R.id.);
        addhl1 = (EditText) view.findViewById(R.id.addhl1);
        addhl2 = (EditText) view.findViewById(R.id.addhl2);
        addhl3 = (EditText) view.findViewById(R.id.addhl3);
        addhl4 = (EditText) view.findViewById(R.id.addhl4);
        addhl5 = (EditText) view.findViewById(R.id.addhl5);
        addhl6 = (EditText) view.findViewById(R.id.addhl6);
        addhl7 = (EditText) view.findViewById(R.id.addhl7);
        addhl8 = (EditText) view.findViewById(R.id.addhl8);

        addhl2.setText(Under5_Core.childidentifier);
        addhl3.setText(Under5_Core.familyidentifier);

        Button button = (Button)view.findViewById(R.id.addhl);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundTaskHR backgroundTaskHR = new BackgroundTaskHR(Under5_Scroll_View.ctx , Under5_Scroll_View.dialog , Under5_Scroll_View.SV);
                backgroundTaskHR.execute("Create" ,
                        addhl2.getText().toString(),
                        addhl3.getText().toString(),
                        addhl1.getText().toString(),
                        addhl4.getText().toString(),
                        addhl5.getText().toString(),
                        addhl6.getText().toString(),
                        addhl7.getText().toString(),
                        addhl8.getText().toString()
                        );
            }
        });

        return view;

    }
}
