package com.caloriescalculator;

import android.content.Intent;
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
                if(!email.isEmpty()&&!password.isEmpty()) {
                    loginUserAccount();
                }
                finish();
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

    private void loginUserAccount() {
        String email, password;
        email = emailText.getText().toString();
        password = passwordText.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                        } else {
                        }
                    }
                });
    }
}