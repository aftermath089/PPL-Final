package com.example.aftermath.hifi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private TextView tvRegister,tvHeader;
    private EditText etEmail, etPassword;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    private void initViews(){
        btnLogin = findViewById(R.id.btn_loginscreen_login);
        tvRegister = findViewById(R.id.tv_loginscreen_register);
        tvHeader = findViewById(R.id.tv_loginscreen_header);
        etEmail = findViewById(R.id.et_loginscreen_email);
        etPassword = findViewById(R.id.et_loginscreen_password);
    }

    private void userLogin(){
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            etEmail.setError("please input your email address");
            return;
        }

        if(TextUtils.isEmpty(password)){
            etPassword.setError("please input your password");
            return;
        }

//        progressDialog.setMessage("Logging in . . .");
//        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
              // progressDialog.hide();

                if(task.isSuccessful()){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,"Wrong Email or Password :(",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_login_screen);
        initViews();

//        if(firebaseAuth.getCurrentUser()!=null){
//            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//            startActivity(intent);
//            finish();
//        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
