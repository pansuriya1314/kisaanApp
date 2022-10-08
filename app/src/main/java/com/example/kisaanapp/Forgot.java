package com.example.kisaanapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Forgot extends AppCompatActivity {

    Button forgotpassword;
    TextInputEditText email;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    ProgressDialog progressDialog;
    TextView backtologin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);


        backtologin = findViewById(R.id.backtologin);
        forgotpassword = findViewById(R.id.forgotpassword);
        email = findViewById(R.id.email);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        progressDialog = new ProgressDialog(this);

        backtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(Forgot.this,login.class);
                startActivity(back);
            }
        });

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Forgotpassword();
            }
        });


    }

    private void Forgotpassword() {

        String Email = email.getText().toString();

        if(Email.isEmpty())
        {
            email.setError("Enter Valid Email");
        }
        else
        {
            progressDialog.setTitle("Forgot Password");
            progressDialog.setMessage("Plese Waiting");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.sendPasswordResetEmail(Email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        Sendtonextactivity();
                        Toast.makeText(Forgot.this, "Send Spam Email", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Forgot.this, "Forgot Password UnSuccessfull"+task.getException().getMessage() ,Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

    private void Sendtonextactivity() {

        Intent forgot = new Intent(Forgot.this,login.class);
        startActivity(forgot);
    }
}