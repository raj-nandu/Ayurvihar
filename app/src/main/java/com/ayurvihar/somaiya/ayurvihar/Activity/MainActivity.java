package com.ayurvihar.somaiya.ayurvihar.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.ayurvihar.somaiya.ayurvihar.Activity.Under5.Under5;
import com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions.BackgroundTask;
import com.ayurvihar.somaiya.ayurvihar.R;
import com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions.TaskComplete;


public class MainActivity extends Activity implements TaskComplete {

    EditText Username , Password;
    public static Button login;
    Context ctx;
    Spinner deptSel;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = getApplicationContext();
        dialog = new ProgressDialog(MainActivity.this);
        deptSel = (Spinner)findViewById(R.id.department_select);
        Username = (EditText) findViewById(R.id.Username);
        Username.setText("admin");
        Password = (EditText) findViewById(R.id.Password);
        Password.setText("admin");
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"comming" ,Toast.LENGTH_LONG );

                if( Username.getText().toString().equals("ADMIN_PASSWORD") && Password.getText().toString().equals("PASSWORD"))
                {
                    startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
                }
                String method = "login";

                BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext() , dialog , MainActivity.this );

                backgroundTask.execute(method, Username.getText().toString(), Password.getText().toString());

            }
        });

    }
    public void LoginTask()
    {
        if( BackgroundTask.Test ) {
            String dept= (String)deptSel.getSelectedItem();
            switch(dept) {

                case "Family Data":
                    Intent intent1 = new Intent(ctx, Family.class);
                    startActivity(intent1);
                    break;

                case "NCD":
                    Intent intent2 = new Intent(ctx, NCD.class);
                    startActivity(intent2);
                    break;
                case "Well Woman":
                    Intent intent3 = new Intent(ctx, WellWoman.class);
                    startActivity(intent3);
                    break;
                case "Under Five":
                    Intent intent4 = new Intent(ctx, Under5.class);
                    startActivity(intent4);
                    break;
            }

        }
    }

}


