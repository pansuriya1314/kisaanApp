package com.example.kisaanapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    TextView register,forgotpassword;
    Button btnlogin;
    TextInputEditText email,password;
    String emailPatten="[A_Za-z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = (TextView) findViewById(R.id.register);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        email=findViewById(R.id.email);
        password= findViewById(R.id.password);
        forgotpassword=findViewById(R.id.forgotpassword);
        progressDialog=new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Forgot=new Intent(login.this,Forgot.class);
                startActivity(Forgot);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Register = new Intent(login.this, register.class);
                startActivity(Register);
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perforauth();
            }
        });
    }

    private void perforauth() {
        String Email = email.getText().toString();
        String Password = password.getText().toString();


       if(!Email.matches(emailPatten))
       {
            email.setError("please proper Email");
       }
        else if (Password.isEmpty() || Password.length() < 6) {
            password.setError("Please proper Password");
        }else {
            progressDialog.setMessage("Please Waiting....");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressDialog.dismiss();
                        sendUserToNextActivvity();
                        Toast.makeText(login.this, "Login", Toast.LENGTH_SHORT).show();
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(login.this, "" + task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void sendUserToNextActivvity() {

        Intent Main = new Intent(login.this, Dashboard.class);
        startActivity(Main);
    }
      @Override
      public void onStart() {

          super.onStart();
          mAuth = FirebaseAuth.getInstance();
          FirebaseUser currentUser = mAuth.getCurrentUser();
          if (currentUser != null) {
              Intent i = new Intent(login.this, Dashboard.class);
              startActivity(i);
              finish();
          }
      }

}