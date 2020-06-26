package com.example.welcome.eride_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VelloreActivity extends AppCompatActivity {
    Button submit;
    Spinner myyspinner;
    Spinner myspinner;
    Button upimage;
    EditText name;
    EditText nos;
    EditText feedback;
    EditText othervoln;
    DatabaseReference databaseorgs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vellore);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        databaseorgs = FirebaseDatabase.getInstance().getReference();
        upimage = findViewById(R.id.vupimg);
        name = findViewById(R.id.vuname);
        nos = findViewById(R.id.vnos);
        feedback = findViewById(R.id.vfeedback);
        myspinner =  findViewById(R.id.spinner1);
        othervoln = findViewById(R.id.vothervol);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(VelloreActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.orgsvellore));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myAdapter);
        myyspinner =  findViewById(R.id.spinner2);
        ArrayAdapter<String> myyAdapter = new ArrayAdapter<String>(VelloreActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.topicstaught));
        myyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myyspinner.setAdapter(myyAdapter);
        submit = findViewById(R.id.update);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                addinfo();
            }
        });

        upimage.setOnClickListener(   new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent I =  new Intent(VelloreActivity.this,ImageUploadActivity.class);
                                              startActivity(I);
                                              Toast.makeText(getApplicationContext(),"Loading..",Toast.LENGTH_SHORT).show();
                                          }
                                      }
        );
    }
    public void addinfo(){
        String orgi = myspinner.getSelectedItem().toString();
        String topic = myyspinner.getSelectedItem().toString();
        String vname = name.getText().toString();
        String vnos = nos.getText().toString();
        String vfeedback = feedback.getText().toString();
        String vothervoln = othervoln.getText().toString();

        if(!TextUtils.isEmpty(orgi)){
            String id = databaseorgs.push().getKey();
            orgs organ = new orgs(id,orgi,topic,vname,vnos,vfeedback,vothervoln);
            databaseorgs.child("Vellore").child(id).setValue(organ);
            Toast.makeText(this,"updated successfully!!",Toast.LENGTH_SHORT).show();

        }
    }
}

