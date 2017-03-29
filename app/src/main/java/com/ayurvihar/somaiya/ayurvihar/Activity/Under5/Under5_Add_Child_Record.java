package com.ayurvihar.somaiya.ayurvihar.Activity.Under5;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ayurvihar.somaiya.ayurvihar.Activity.MainActivity;
import com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions.BackgroundTaskCR;
import com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions.TaskCompleteCR;
import com.ayurvihar.somaiya.ayurvihar.R;

public class Under5_Add_Child_Record extends Activity implements TaskCompleteCR{

    public ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under5__add__new);

        dialog = new ProgressDialog(Under5_Add_Child_Record.this);
        final EditText Addn1 , Addn2 , Addn3 , Addn4 , Addn5 , Addn6 , Addn7 , Addn8 , Addn9;
        Addn1 = (EditText) findViewById(R.id.Addn1);
        Addn2 = (EditText) findViewById(R.id.Addn2);
        Addn3 = (EditText) findViewById(R.id.Addn3);
        Addn4 = (EditText) findViewById(R.id.Addn4);
        Addn5 = (EditText) findViewById(R.id.Addn5);
        Addn6 = (EditText) findViewById(R.id.Addn6);
        Addn7 = (EditText) findViewById(R.id.Addn7);
        Addn8 = (EditText) findViewById(R.id.Addn8);
        Addn9 = (EditText) findViewById(R.id.Addn9);
        Button AddRecord = (Button) findViewById(R.id.AddRecord);

        AddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundTaskCR backgroundTaskCR = new BackgroundTaskCR(getApplicationContext(),dialog,Under5_Add_Child_Record.this);
                backgroundTaskCR.execute("Create" ,
                        Addn1.getText().toString(),
                        Addn2.getText().toString(),
                        Addn3.getText().toString(),
                        Addn4.getText().toString(),
                        Addn5.getText().toString(),
                        Addn6.getText().toString(),
                        Addn7.getText().toString(),
                        Addn8.getText().toString(),
                        Addn9.getText().toString());
            }
        });
    }
    public void TaskCreate()
    {
        finish();
    }
    public void TaskUpdate()
    {

    }
    public void TaskRecords()
    {

    }

}
