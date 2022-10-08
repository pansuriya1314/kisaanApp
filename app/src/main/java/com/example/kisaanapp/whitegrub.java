package com.example.kisaanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class whitegrub extends AppCompatActivity {
    ImageView back;
    TextView details,soilinfo,fertidetail;
    LinearLayout layout,soil,fertilizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whitegrub);

        back=(ImageView) findViewById(R.id.back1) ;
        details=findViewById(R.id.details);
        layout=findViewById(R.id.layout);
        soilinfo=findViewById(R.id.soilinfo);
        soil=findViewById(R.id.soil);
        fertidetail=findViewById(R.id.fertidetail);
        fertilizer=findViewById(R.id.fertilizer);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back=new Intent(whitegrub.this,cropcare.class);
                startActivity(back);
            }
        });

    }
    public void expand(View view) {
        int v=(details.getVisibility()==View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        details.setVisibility(v);

        int u=(soilinfo.getVisibility()==View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(soil, new AutoTransition());
        soilinfo.setVisibility(u);

        int x=(fertidetail.getVisibility()==View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(fertilizer, new AutoTransition());
        fertidetail.setVisibility(x);
    }
}