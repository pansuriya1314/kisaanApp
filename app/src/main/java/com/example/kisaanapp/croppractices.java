package com.example.kisaanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class croppractices extends AppCompatActivity {

    ImageView back,wheat,cotton,tea,greengram,coconut,corn,groundnut,castor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_croppractices);

        back=findViewById(R.id.back);
        wheat=findViewById(R.id.wheat);
        cotton=findViewById(R.id.cotton);
        tea=findViewById(R.id.tea);
        greengram=findViewById(R.id.greengram);
        coconut=findViewById(R.id.coconut);
        corn=findViewById(R.id.corn);
        groundnut=findViewById(R.id.groundnut);
        castor=findViewById(R.id.castor);

        wheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wheat=new Intent(croppractices.this,wheat.class);
                startActivity(wheat);
            }
        });
        cotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wheat=new Intent(croppractices.this,cotton.class);
                startActivity(wheat);
            }
        });
        tea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wheat=new Intent(croppractices.this,tea.class);
                startActivity(wheat);
            }
        });
        greengram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wheat=new Intent(croppractices.this,greengram.class);
                startActivity(wheat);
            }
        });
        coconut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wheat=new Intent(croppractices.this,coconut.class);
                startActivity(wheat);
            }
        });
        corn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wheat=new Intent(croppractices.this,corn.class);
                startActivity(wheat);
            }
        });
        groundnut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wheat=new Intent(croppractices.this,groundnut.class);
                startActivity(wheat);
            }
        });
        castor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wheat=new Intent(croppractices.this,castor.class);
                startActivity(wheat);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back=new Intent(croppractices.this,Dashboard.class);
                startActivity(back);
            }
        });

    }
}