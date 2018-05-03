package com.example.kaseyclark.soconnected2;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Logon extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private FirebaseAuth mAuth;
    private String email;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logon);

        emailEditText = (EditText) findViewById(R.id.et_email);
        passwordEditText = (EditText)findViewById(R.id.et_password);
        mAuth = FirebaseAuth.getInstance();

    }
    public void signup (View view){
        email = emailEditText.getText().toString();
        password=passwordEditText.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(Logon.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText( Logon.this, task.getResult().getUser().getEmail()+" sign up sucessful", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
    public void logon (View view){
        email = emailEditText.getText().toString();
        password=passwordEditText.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(Logon.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText( Logon.this, task.getResult().getUser().getEmail()+" sign up sucessful", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
