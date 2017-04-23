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
import com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions.BackgroundTaskCR;
import com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions.BackgroundTaskIM;
import com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions.BackgroundTaskHR;

import com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions.TaskCompleteCR;
import com.ayurvihar.somaiya.ayurvihar.R;
import com.ayurvihar.somaiya.ayurvihar.Under5_Scroll_View;

public class Under5_OnePlace extends Activity implements TaskCompleteCR {

    BackgroundTaskCR backgroundTaskCR;
    BackgroundTaskIM backgroundTaskIM;
    BackgroundTaskHR backgroundTaskHR;

    public ProgressDialog dialog;
    EditText cid ;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_place);
        cid = (EditText) findViewById(R.id.cid);
        btn = (Button) findViewById(R.id.loginAll);
        dialog = new ProgressDialog(Under5_OnePlace.this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundTaskCR = new BackgroundTaskCR(getApplicationContext() , dialog , Under5_OnePlace.this);
                backgroundTaskCR.execute("Select" ,cid.getText().toString(),"");
                // ToDo Uncomment these
                backgroundTaskIM = new BackgroundTaskIM(getApplicationContext() , dialog , Under5_OnePlace.this);
                backgroundTaskIM.execute("Select" ,cid.getText().toString(),"");
                backgroundTaskHR = new BackgroundTaskHR(getApplicationContext() , dialog , Under5_OnePlace.this);
                backgroundTaskHR.execute("Select" ,cid.getText().toString(),"");

            }
        });
    }

    @Override
    public void TaskCreate() {    }

    int count=0;
    @Override
    public void TaskRecords() {
        count++;
        if( count == 3) {
            if (backgroundTaskCR.Present) {

                Intent i = new Intent(getApplicationContext(), Under5_Scroll_View.class);
                i.putExtra("cid", cid.getText().toString());
                startActivity(i);
            } else {
                Toast.makeText(this, "No Records Found", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void TaskUpdate() {    }
}
