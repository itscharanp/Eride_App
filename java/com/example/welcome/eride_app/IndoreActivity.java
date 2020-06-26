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

public class IndoreActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_indore);
        databaseorgs = FirebaseDatabase.getInstance().getReference();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        upimage = findViewById(R.id.iupimg);
        name = findViewById(R.id.iuname);
        nos = findViewById(R.id.inos);
        othervoln = findViewById(R.id.iothervol);
        feedback = findViewById(R.id.ifeedback);
        myspinner =  findViewById(R.id.spinner3);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(IndoreActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.orgsvellore));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myAdapter);
        myyspinner =  findViewById(R.id.spinner4);
        ArrayAdapter<String> myyAdapter = new ArrayAdapter<String>(IndoreActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.topicstaught));
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
                                              Intent I =  new Intent(IndoreActivity.this,ImageUploadActivity.class);
                                              startActivity(I);
                                              Toast.makeText(getApplicationContext(),"Loading..",Toast.LENGTH_SHORT).show();
                                          }
                                      }
        );
    }

    public void addinfo(){
        String orgi = myspinner.getSelectedItem().toString();
        String topic = myyspinner.getSelectedItem().toString();
        String iname = name.getText().toString();
        String inos = nos.getText().toString();
        String ifeedback = feedback.getText().toString();
        String  dothervoln = othervoln.getText().toString();

        if(!TextUtils.isEmpty(orgi)){
            String id = databaseorgs.push().getKey();
            orgs organ = new orgs(id,orgi,topic,iname,inos,ifeedback,dothervoln);
            databaseorgs.child("Internal participants").child(id).setValue(organ);
            Toast.makeText(this,"updated successfully!!",Toast.LENGTH_SHORT).show();
        }
    }
}
