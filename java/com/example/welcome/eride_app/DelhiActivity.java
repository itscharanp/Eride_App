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

public class DelhiActivity extends AppCompatActivity {
    Button submit;
    Spinner myyspinner;
    Spinner myspinner;
    Button upimg;
    EditText name;
    EditText othervoln;
    EditText feedback;
    EditText nos;
    DatabaseReference databaseorgs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delhi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        upimg = findViewById(R.id.dupimg);
        databaseorgs = FirebaseDatabase.getInstance().getReference();
        feedback = findViewById(R.id.dfeedback);
        name = findViewById(R.id.duname);
        nos = findViewById(R.id.dnos);
        myspinner =  findViewById(R.id.spinner5);
        othervoln = findViewById(R.id.dothervol);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(DelhiActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.orgsdelhi));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myAdapter);
        myyspinner =  findViewById(R.id.spinner6);
        ArrayAdapter<String> myyAdapter = new ArrayAdapter<String>(DelhiActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.topicstaught));
        myyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myyspinner.setAdapter(myyAdapter);
        submit = findViewById(R.id.update);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                addinfo();
            }
        });
        upimg.setOnClickListener(   new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent I =  new Intent(DelhiActivity.this,ImageUploadActivity.class);
                                            startActivity(I);
                                            Toast.makeText(getApplicationContext(),"Loading..",Toast.LENGTH_SHORT).show();
                                        }
                                    }
        );

    }
    public void addinfo(){
        String orgi = myspinner.getSelectedItem().toString();
        String topic = myyspinner.getSelectedItem().toString();
        String dname = name.getText().toString();
        String dnos = nos.getText().toString();
        String dfeedback = feedback.getText().toString();
        String dothervol = othervoln.getText().toString();
        if(!TextUtils.isEmpty(orgi)){
            String id = databaseorgs.push().getKey();
            orgs organ = new orgs(id,orgi,topic,dname,dnos,dfeedback,dothervol);
            databaseorgs.child("Volunteers").child(id).setValue(organ);
            Toast.makeText(this,"updated successfully!!",Toast.LENGTH_SHORT).show();
        }
    }
}
