package com.ayurvihar.somaiya.ayurvihar.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ayurvihar.somaiya.ayurvihar.R;

/**
 * Created by ABC on 23-Apr-17.
 */

public class Tab2 extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //Inflate the view for this fragment
        View view=inflater.inflate(R.layout.tab2_immunization,container,false);
        return view;
    }
}
