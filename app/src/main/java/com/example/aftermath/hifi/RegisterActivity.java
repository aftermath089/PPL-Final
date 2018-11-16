package com.example.aftermath.hifi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private Button btnRegister;
    private EditText etEmail, etPassword, etPasswordCheck;
    private TextView tvHeader, tvLogin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    private void initViews(){
        btnRegister = findViewById(R.id.btn_register_register);
        etEmail = findViewById(R.id.et_register_email);
        etPassword = findViewById(R.id.et_register_password);
        etPasswordCheck = findViewById(R.id.et_register_passwordcheck);
        tvHeader = findViewById(R.id.tv_register_header);
        tvLogin = findViewById(R.id.tv_register_login);
    }

    private void registerUser(){
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String passwordCheck = etPasswordCheck.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            etEmail.setError("please input your email address");
            return;
        }

        if(TextUtils.isEmpty(password)){
            etPassword.setError("please input your password");
            return;
        }

        if(TextUtils.isEmpty(passwordCheck)){
            etPasswordCheck.setError("please re-type your password");
            return;
        }

        if(!TextUtils.equals(password,passwordCheck)){
            etPasswordCheck.setError("password doesnt match!");
            return;
        }

        progressDialog.setMessage("Registering . . .");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Registered!", Toast.LENGTH_SHORT).show();
                    progressDialog.hide();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                    //lempar ke login screen?
                }else{
                    Toast.makeText(RegisterActivity.this, "Something bad happened, please try again :(", Toast.LENGTH_SHORT).show();
                    progressDialog.hide();
                    return;
                }
            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth = FirebaseAuth.getInstance();
        initViews();

        progressDialog = new ProgressDialog(this);

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }
}
