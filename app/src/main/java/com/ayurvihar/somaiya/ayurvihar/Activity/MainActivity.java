package com.ayurvihar.somaiya.ayurvihar.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ayurvihar.somaiya.ayurvihar.BackgroundTask;
import com.ayurvihar.somaiya.ayurvihar.R;

public class MainActivity extends Activity {

    EditText Username , Password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.Password);

        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( Username.getText().toString().equals("ADMIN_PASSWORD") && Password.getText().toString().equals("PASSWORD"))
                {
                    startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
                }
                else {
                    String method = "login";
                    BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext());
                    backgroundTask.execute(method, Username.getText().toString(), Password.getText().toString());
                }
            }
        });
    }
}
