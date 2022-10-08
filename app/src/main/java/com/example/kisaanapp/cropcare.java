package com.example.kisaanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class cropcare extends AppCompatActivity {

    ImageView back,fruitmolds,peanutrust,termites,whitegrub,blackmould,aphids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cropcare);

        back=findViewById(R.id.back);

        aphids=findViewById(R.id.aphids);
        blackmould=findViewById(R.id.blackmould);
        fruitmolds=findViewById(R.id.fruitmolds);
        peanutrust=findViewById(R.id.peanutrust);
        termites=findViewById(R.id.termites);
        whitegrub=findViewById(R.id.whitegrub);

        aphids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aphids=new Intent(cropcare.this,aphids.class);
                startActivity(aphids);

            }
        });

        blackmould.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aphids=new Intent(cropcare.this,blackmould.class);
                startActivity(aphids);

            }
        });

        fruitmolds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aphids=new Intent(cropcare.this,fruitmolds.class);
                startActivity(aphids);

            }
        });

        peanutrust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aphids=new Intent(cropcare.this,peanutrust.class);
                startActivity(aphids);

            }
        });

        termites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(cropcare.this,termites.class);
                startActivity(i);
            }
        });

        whitegrub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aphids=new Intent(cropcare.this,whitegrub.class);
                startActivity(aphids);

            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back=new Intent(cropcare.this,Dashboard.class);
                startActivity(back);
            }
        });
    }
}