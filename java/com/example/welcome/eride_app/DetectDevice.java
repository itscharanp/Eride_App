package com.example.welcome.eride_app;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.os.Build.getSerial;

public class DetectDevice extends AppCompatActivity {
    Button submit;
    Button database;
    Button Image;
    private TextView textViewSetInformation;
    private Button buttonGetInformation;
    DatabaseReference databaseorgs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detect_device);
        database = findViewById(R.id.db);
        Image = findViewById(R.id.up);
        initViews();
        initListeners();
        databaseorgs = FirebaseDatabase.getInstance().getReference();
        submit = findViewById(R.id.updateinfo);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addinfo();
            }
        });

        database.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent I = new Intent(DetectDevice.this, IndoreActivity.class);
                        startActivity(I);
                        finish();
                        Toast.makeText(getApplicationContext(), "Loading..", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        Image.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent I = new Intent(DetectDevice.this, ImageUploadActivity.class);
                        startActivity(I);
                        finish();
                        Toast.makeText(getApplicationContext(), "Loading..", Toast.LENGTH_SHORT).show();
                    }
                }
        );


    }

    private void initViews() {

        textViewSetInformation = (TextView) findViewById(R.id.textViewSetInformation);

        buttonGetInformation = (Button) findViewById(R.id.buttonGetInformation);

    }

    private void initListeners() {

        buttonGetInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get hardware and software information
                String information = getHardwareAndSoftwareInfo();

                // set information to text view
                textViewSetInformation.setText(information);

            }
        });

    }

    private String getHardwareAndSoftwareInfo() {

        return getString(R.string.serial) + " " + Build.SERIAL + "\n" +
                getString(R.string.model) + " " + Build.MODEL + "\n" +
                getString(R.string.id) + " " + Build.ID + "\n" +
                getString(R.string.manufacturer) + " " + Build.MANUFACTURER + "\n" +
                getString(R.string.brand) + " " + Build.BRAND + "\n" +
                getString(R.string.type) + " " + Build.TYPE + "\n" +
                getString(R.string.user) + " " + Build.USER + "\n" +
                getString(R.string.base) + " " + Build.VERSION_CODES.BASE + "\n" +
                getString(R.string.incremental) + " " + Build.VERSION.INCREMENTAL + "\n" +
                getString(R.string.sdk) + " " + Build.VERSION.SDK + "\n" +
                getString(R.string.board) + " " + Build.BOARD + "\n" +
                getString(R.string.host) + " " + Build.HOST + "\n" +
                getString(R.string.fingerprint) + " " + Build.FINGERPRINT + "\n" +
                getString(R.string.versioncode) + " " + Build.VERSION.RELEASE;
    }

    public void addinfo() {
        String serial = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            serial = "" + getSerial();
        }
        String model = "" + Build.MODEL;
        String id = "" +Build.ID;
        String manf = "" +Build.MANUFACTURER ;
        String  brand = "" + Build.BRAND;
        String  type = "" + Build.TYPE ;
        String  user = "" +Build.USER ;
        String base = "" + Build.VERSION_CODES.BASE;
        String incre = ""+ Build.VERSION.INCREMENTAL ;
        String sdk = "" + Build.VERSION.SDK;
        String board = "" + Build.BOARD;
        String host = ""+Build.HOST;
        String fingerprint = "" +Build.FINGERPRINT ;
        String versioncode  = "" +Build.VERSION.RELEASE ;

        if(!TextUtils.isEmpty(serial)){
            String x = databaseorgs.push().getKey();
            abc organ = new abc(serial,model,id,manf,brand,type,user,base,incre,sdk,board,host,fingerprint);
            databaseorgs.child("DEVICES_INFO").child(serial).setValue(organ);
            Toast.makeText(this,"updated successfully!!",Toast.LENGTH_SHORT).show();
        }
    }





}
