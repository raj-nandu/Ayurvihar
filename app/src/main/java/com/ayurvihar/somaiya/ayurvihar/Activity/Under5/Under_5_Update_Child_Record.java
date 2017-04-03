package com.ayurvihar.somaiya.ayurvihar.Activity.Under5;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions.BackgroundTaskCR;
import com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions.TaskCompleteCR;
import com.ayurvihar.somaiya.ayurvihar.R;

public class Under_5_Update_Child_Record extends Activity implements TaskCompleteCR {

    public ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under_5__update__child__record);
        dialog = new ProgressDialog(Under_5_Update_Child_Record.this);
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
        Button AddRecord = (Button) findViewById(R.id.Search2);

        Addn2.setAlpha(0.0f);
        Addn3.setAlpha(0.0f);
        Addn4.setAlpha(0.0f);
        Addn5.setAlpha(0.0f);
        Addn6.setAlpha(0.0f);
        Addn7.setAlpha(0.0f);
        Addn8.setAlpha(0.0f);
        Addn9.setAlpha(0.0f);

        AddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundTaskCR backgroundTaskCR = new BackgroundTaskCR(getApplicationContext() , dialog , Under_5_Update_Child_Record.this);
                backgroundTaskCR.execute("Select");
            }
        });
    }

    public void TaskCreate()
    {

    }
    public void TaskUpdate()
    {

    }
    public void TaskRecords()
    {
    }
}
