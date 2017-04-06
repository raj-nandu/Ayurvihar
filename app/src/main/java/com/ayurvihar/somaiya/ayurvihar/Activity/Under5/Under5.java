package com.ayurvihar.somaiya.ayurvihar.Activity.Under5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ayurvihar.somaiya.ayurvihar.R;

public class Under5 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under5);

        ImageButton add = (ImageButton) findViewById(R.id.AddNew);
        ImageButton update = (ImageButton) findViewById(R.id.Update);
        ImageButton Search = (ImageButton) findViewById(R.id.Search);
        ImageButton viewandupdate = (ImageButton) findViewById(R.id.ViewAndUpdate);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Under5_Add_Child_Record.class);
                startActivity(i);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Under_5_Update_Child_Record.class);
                i.putExtra("type" , "!Scan");
                startActivity(i);
            }
        });

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Under_5_Update_Child_Record.class);
                i.putExtra("type" , "Scan");
                startActivity(i);
            }
        });

        viewandupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Under5.this, "Called", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),Under5_OnePlace.class);
                startActivity(i);
            }
        });
    }
}
