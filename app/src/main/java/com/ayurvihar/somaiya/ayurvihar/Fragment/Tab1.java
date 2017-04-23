package com.ayurvihar.somaiya.ayurvihar.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.ayurvihar.somaiya.ayurvihar.Activity.Under5.Under5_Core;
import com.ayurvihar.somaiya.ayurvihar.Activity.Under5.Under5_OnePlace;
import com.ayurvihar.somaiya.ayurvihar.Activity.Under5.Under_5_Update_Child_Record;
import com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions.BackgroundTaskCR;
import com.ayurvihar.somaiya.ayurvihar.R;
import com.ayurvihar.somaiya.ayurvihar.Under5_Scroll_View;

import java.util.Calendar;

/**
 * Created by ABC on 23-Apr-17.
 */

public class Tab1 extends Fragment {

    public ProgressDialog dialog = new ProgressDialog(Under5_Scroll_View.this);
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    EditText Addn1 , Addn2 , Addn3 , Addn4 , Addn5 , Addn6 , Addn7 , Addn8 , Addn9;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        //Inflate the view for this fragment
        View view=inflater.inflate(R.layout.tab1_child_data,container,false);
        dateView = (TextView)view.findViewById(R.id.Addn8);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);


        Addn1 = (EditText) view.findViewById(R.id.Addn1);
        Addn2 = (EditText) view.findViewById(R.id.Addn2);
        Addn3 = (EditText) view.findViewById(R.id.Addn3);
        Addn4 = (EditText) view.findViewById(R.id.Addn4);
        Addn5 = (EditText) view.findViewById(R.id.Addn5);
        Addn6 = (EditText) view.findViewById(R.id.Addn6);
        Addn7 = (EditText) view.findViewById(R.id.Addn7);
        Addn8 = (EditText) view.findViewById(R.id.Addn8);
        Addn9 = (EditText) view.findViewById(R.id.Addn9);
        Button update = (Button) view.findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundTaskCR backgroundTaskCR = new BackgroundTaskCR( Under5_Scroll_View.ctx, dialog , under5);
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