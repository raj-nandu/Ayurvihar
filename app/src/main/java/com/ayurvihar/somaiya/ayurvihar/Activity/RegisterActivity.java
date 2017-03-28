package com.ayurvihar.somaiya.ayurvihar.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions.BackgroundTask;
import com.ayurvihar.somaiya.ayurvihar.R;

public class RegisterActivity extends Activity {

    EditText Username , Password1 , Password2;
    Button  Register;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Username = (EditText) findViewById(R.id.Username);
        Password1 = (EditText) findViewById(R.id.Password);
        Password2 = (EditText) findViewById(R.id.Password2);
        dialog = new ProgressDialog(RegisterActivity.this);
        Register = (Button) findViewById(R.id.register);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( Password1.getText().toString().equals(Password2.getText().toString()))
                {
                    String method = "register";
                    BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext(), dialog , null );
                    backgroundTask.execute(method,Username.getText().toString(),Password1.getText().toString());
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }

            }
        });
    }
}
