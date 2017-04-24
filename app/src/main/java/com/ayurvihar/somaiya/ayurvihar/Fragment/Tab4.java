package com.ayurvihar.somaiya.ayurvihar.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ayurvihar.somaiya.ayurvihar.Activity.Under5.Under5_Health_Record_Core;
import com.ayurvihar.somaiya.ayurvihar.R;

import java.util.ArrayList;


public class Tab4 extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    ListView l;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //Inflate the view for this fragment
        View view=inflater.inflate(R.layout.fragment_tab4,container,false);

        l = (ListView) view.findViewById(R.id.listView);
        ArrayList<String> Str = new ArrayList<>();
        for( int i = 0 ; i < Under5_Health_Record_Core.hr.size() ; i++ )
        {
            Str.add("Health Checkup No.:" + Under5_Health_Record_Core.hr.get(i).childhealthcheckupnumber
            + "\nDate:"+Under5_Health_Record_Core.hr.get(i).checkupdate
            +"\nHeight:" + Under5_Health_Record_Core.hr.get(i).height + "\t"
                            +"Weight:" +Under5_Health_Record_Core.hr.get(i).weight
            + "\nWeight For Age Status:"+Under5_Health_Record_Core.hr.get(i).weightforagestatus
                    +"\nRemarks:"+Under5_Health_Record_Core.hr.get(i).remarks+"\n"
            );
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Under5_Scroll_View.ctx, R.layout.l_textview , Str);

        l.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
        return view;
    }
}
