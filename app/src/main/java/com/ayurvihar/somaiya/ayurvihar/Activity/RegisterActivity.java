package com.ayurvihar.somaiya.ayurvihar.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ayurvihar.somaiya.ayurvihar.BackgroundTask;
import com.ayurvihar.somaiya.ayurvihar.R;

public class RegisterActivity extends Activity {

    EditText Username , Password1 , Password2;
    Button  Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Username = (EditText) findViewById(R.id.Username);
        Password1 = (EditText) findViewById(R.id.Password);
        Password2 = (EditText) findViewById(R.id.Password2);

        Register = (Button) findViewById(R.id.register);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( Password1.getText().toString().equals(Password2.getText().toString()))
                {
                    String method = "register";
                    BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext());
                    backgroundTask.execute(method,Username.getText().toString(),Password1.getText().toString());
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }

            }
        });
    }
}
