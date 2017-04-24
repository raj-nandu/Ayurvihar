package com.ayurvihar.somaiya.ayurvihar.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ayurvihar.somaiya.ayurvihar.R;


public class Tab4 extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //Inflate the view for this fragment
        View view=inflater.inflate(R.layout.fragment_tab4,container,false);

        return view;
    }
}
