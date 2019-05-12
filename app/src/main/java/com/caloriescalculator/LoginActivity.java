package com.caloriescalculator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailText, passwordText;
    private Button signInBut, signUpBut;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.sign_in_button).setOnClickListener(this);
        emailText = findViewById(R.id.email);
        passwordText = findViewById(R.id.password);
        signInBut = findViewById(R.id.sign_in_button);
        signUpBut = findViewById(R.id.sign_up_button);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    @Override
    public void onClick(View v) {

        String email, password;
        email = emailText.getText().toString();
        password = passwordText.getText().toString();

        switch (v.getId()) {
            case R.id.sign_in_button:
                loginUserAccount();
                finish();
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

    private void loginUserAccount() {
        final String email, password;
        email=getEmailText();
        password=getPwdText();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        while (!task.isSuccessful()) {
                            int red = Color.parseColor("#FF0000");
                            int white = Color.WHITE;
                            if (email.isEmpty() && password.isEmpty()) {
                                emailText.setBackgroundColor(red);
                                passwordText.setBackgroundColor(red);
                                signInBut.setEnabled(false);
                            } else {
                                emailText.setBackgroundColor(white);
                                passwordText.setBackgroundColor(white);
                                signInBut.setEnabled(true);
                            }
                        }

                    }
                });
    }
    String getEmailText(){
        String email="";
        try {
            email = emailText.getText().toString();
        }
        catch(NullPointerException e){
            emailText.setBackgroundColor(Color.parseColor("#FF0000"));
            email="";
        }
        return email;
    }

    String getPwdText(){
        String pwd="";
        try {
            pwd = passwordText.getText().toString();
        }
        catch(NullPointerException e){
            passwordText.setBackgroundColor(Color.parseColor("#FF0000"));
            pwd="";
        }
        return pwd;
    }
}