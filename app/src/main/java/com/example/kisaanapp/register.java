package com.example.kisaanapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
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

public class register extends AppCompatActivity {

    TextInputEditText email,password,confirmpassword;
    Button btnregister;
    TextView signin;
    String emailPatten="[A_Za-z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email =findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.confirmpassword);
        btnregister=findViewById(R.id.btnRegister);
        signin =(TextView) findViewById(R.id.signin);
        progressDialog=new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Signin=new Intent(register.this,login.class);
                startActivity(Signin);
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perforauth();
            }
        });

    }

    private void perforauth() {
        String Email = email.getText().toString();
        //Toast.makeText(getApplicationContext(),Email,Toast.LENGTH_LONG).show();
        String Password = password.getText().toString();
        String ConfirmPassword = confirmpassword.getText().toString();

        if(!Email.matches(emailPatten))
        {
            email.setError("Please Valid Email");
        }
        else if(Password.isEmpty() || Password.length()<6)
        {
            password.setError("Please proper Password");
        }
        else if(!Password.equals(ConfirmPassword))
        {
            confirmpassword.setError("Please do not match Password");
        }
        else
        {
            progressDialog.setMessage("Please Waiting....");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        sendUserToNextActivvity();
                        Toast.makeText(register.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(register.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void sendUserToNextActivvity() {

        Intent Main = new Intent(register.this,login.class);
        startActivity(Main);
        finish();
    }
}