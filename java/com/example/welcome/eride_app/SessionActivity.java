package com.example.welcome.eride_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SessionActivity extends AppCompatActivity {

    private Button Vellore;
    private Button Indore;
    private Button Delhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);

        Vellore = findViewById(R.id.vellore);
        Indore = findViewById(R.id.indore);
        Delhi = findViewById(R.id.delhi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Vellore.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent I =  new Intent(SessionActivity.this,VelloreActivity.class);
                        startActivity(I);
                        Toast.makeText(getApplicationContext(),"Loading..",Toast.LENGTH_SHORT).show();
                    }
                }

        );


        Indore.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent I =  new Intent(SessionActivity.this,IndoreActivity.class);
                        startActivity(I);
                        Toast.makeText(getApplicationContext(),"Loading..",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        Delhi.setOnClickListener(


                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent I =  new Intent(SessionActivity.this,DelhiActivity.class);
                        startActivity(I);
                        Toast.makeText(getApplicationContext(),"Loading..",Toast.LENGTH_SHORT).show();
                    }
                }



        );



    }
}
