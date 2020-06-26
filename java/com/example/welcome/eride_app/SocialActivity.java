package com.example.welcome.eride_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SocialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_social);
        Button f = findViewById(R.id.fb);
        f.setMovementMethod(LinkMovementMethod.getInstance());

        Button t = findViewById(R.id.twi);
        t.setMovementMethod(LinkMovementMethod.getInstance());

        Button i = findViewById(R.id.insta);
        i.setMovementMethod(LinkMovementMethod.getInstance());

        Button l = findViewById(R.id.li);
        l.setMovementMethod(LinkMovementMethod.getInstance());


    }
}
