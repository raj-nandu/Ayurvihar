package com.ayurvihar.somaiya.ayurvihar.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ayurvihar.somaiya.ayurvihar.Activity.Under5.Under5_Core;
import com.ayurvihar.somaiya.ayurvihar.R;

/**
 * Created by ABC on 23-Apr-17.
 */

public class Tab1 extends Fragment {

    TextView txt1;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        //Inflate the view for this fragment
        View view=inflater.inflate(R.layout.tab1_child_data,container,false);
        txt1=(TextView)view.findViewById(R.id.textViewTab1);
        String childData= "Child Name: "+Under5_Core.childname+
                            "\nChild Identifier: "+Under5_Core.childidentifier+
                            "\nFamily Identifier: "+Under5_Core.familyidentifier+
                            "\nMother's Name: "+Under5_Core.mothername+
                            "\nFather's Name: "+Under5_Core.fathername+
                            "\nAddress: "+Under5_Core.address+
                            "\nMobile Number: "+Under5_Core.mobilenumber+
                            "\nDate of Birth: "+Under5_Core.dob+
                            "\nSex: "+Under5_Core.sex;
        txt1.setText(childData);
        return view;
    }
}