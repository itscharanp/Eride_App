
package com.example.welcome.eride_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;

public class LegalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legal);
        Button f = findViewById(R.id.ld);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        f.setMovementMethod(LinkMovementMethod.getInstance());



    }
}
