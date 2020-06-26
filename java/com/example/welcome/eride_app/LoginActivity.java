package com.example.welcome.eride_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonsignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignup;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth =FirebaseAuth.getInstance();

//        if(firebaseAuth.getCurrentUser()!=null){
//            startActivity(new Intent(LoginActivity.this,DetectDevice.class));
//            finish();
//        }
        editTextEmail = findViewById(R.id.editTextemail);
        editTextPassword = findViewById(R.id.editTextpassword);
        buttonsignIn = findViewById(R.id.buttonRegister);
        textViewSignup = findViewById(R.id.textViewSignup);
        progressDialog = new ProgressDialog(this);
        buttonsignIn.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);



    }
    private void userlogin()
    {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this,"please Enter the password",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful())
                        {
                            progressDialog.setMessage("logging in....");
                            startActivity(new Intent(LoginActivity.this,VelloreActivity.class));
                        }
                        else
                        {
                            progressDialog.setMessage("wrong credentials!!" + "....");
                        }
                    }
                });

    }

    @Override
    public void onClick(View view) {
        if(view == buttonsignIn){
            if(view == buttonsignIn){
                userlogin();
            }
        }
        if(view == textViewSignup)
            startActivity(new Intent(this,MainActivity.class));
    }
}

