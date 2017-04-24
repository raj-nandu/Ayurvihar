package com.ayurvihar.somaiya.ayurvihar.Activity.Under5;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions.BackgroundTaskCR;
import com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions.TaskCompleteCR;
import com.ayurvihar.somaiya.ayurvihar.R;

import java.util.Calendar;

public class Under_5_Update_Child_Record extends Activity implements TaskCompleteCR {

    public ProgressDialog dialog;

    EditText Addn1 , Addn2 , Addn3 , Addn4 , Addn5 , Addn6 , Addn7 , Addn8 , Addn9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();


        setContentView(R.layout.activity_under_5__update__child__record);

        dialog = new ProgressDialog(Under_5_Update_Child_Record.this);


        Addn1 = (EditText) findViewById(R.id.Addn1);
        Addn2 = (EditText) findViewById(R.id.Addn2);
        Addn3 = (EditText) findViewById(R.id.Addn3);
        Addn4 = (EditText) findViewById(R.id.Addn4);
        Addn5 = (EditText) findViewById(R.id.Addn5);
        Addn6 = (EditText) findViewById(R.id.Addn6);
        Addn7 = (EditText) findViewById(R.id.Addn7);
        Addn8 = (EditText) findViewById(R.id.Addn8);
        Addn9 = (EditText) findViewById(R.id.Addn9);
        Button AddRecord = (Button) findViewById(R.id.Search2);
        Button update = (Button) findViewById(R.id.update);


        if( i.getStringExtra("type").equals("Scan"))
        {
            update.setEnabled(false);
            update.setAlpha(0.0f);
            update.setText("");
        }

        AddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundTaskCR backgroundTaskCR = new BackgroundTaskCR(getApplicationContext() , dialog , Under_5_Update_Child_Record.this);
                backgroundTaskCR.execute("Select" ,Addn1.getText().toString(),
                        Addn2.getText().toString() );

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundTaskCR backgroundTaskCR = new BackgroundTaskCR(getApplicationContext() , dialog , Under_5_Update_Child_Record.this);
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
    }

    public void TaskCreate() {}
    public void TaskUpdate() {}
    public void  TaskRecords() {
        Addn1.setText(Under5_Core.childidentifier);
        Addn2.setText(Under5_Core.familyidentifier);
        Addn3.setText(Under5_Core.address);
        Addn4.setText(Under5_Core.mobilenumber);
        Addn5.setText(Under5_Core.childname);
        Addn6.setText(Under5_Core.fathername);
        Addn7.setText(Under5_Core.mothername);
        Addn8.setText(Under5_Core.dob);
        Addn9.setText(Under5_Core.sex);
    }

}
