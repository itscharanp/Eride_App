package com.example.welcome.eride_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {


    Button Login;
    Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Login = findViewById(R.id.login);
        Register = findViewById(R.id.register);

        Login.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent I =  new Intent(FirstActivity.this,LoginActivity.class);
                        startActivity(I);
                        finish();
                        Toast.makeText(getApplicationContext(),"Loading..",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        Register.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent I =  new Intent(FirstActivity.this,MainActivity.class);
                        startActivity(I);
                        finish();
                        Toast.makeText(getApplicationContext(),"Loading..",Toast.LENGTH_SHORT).show();
                    }
                }
        );


    }
}
