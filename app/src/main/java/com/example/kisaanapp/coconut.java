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

public class coconut extends AppCompatActivity {

    ImageView back;
    TextView detailtext,soilinfo,fertidetail,harvestingdetail;
    LinearLayout layout,soil,fertilizer,harvesting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coconut);

        back=findViewById(R.id.back);
        detailtext=findViewById(R.id.details);
        layout=findViewById(R.id.layout);
        soilinfo=findViewById(R.id.soilinfo);
        soil=findViewById(R.id.soil);
        harvestingdetail=findViewById(R.id.harvestingdetail);
        harvesting=findViewById(R.id.harvesting);
        fertidetail=findViewById(R.id.fertidetail);
        fertilizer=findViewById(R.id.fertilizer);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back=new Intent(coconut.this,croppractices.class);
                startActivity(back);
            }
        });

    }
    public void expand(View view) {
        int v=(detailtext.getVisibility()==View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        detailtext.setVisibility(v);

        int u=(soilinfo.getVisibility()==View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(soil, new AutoTransition());
        soilinfo.setVisibility(u);

        int w=(harvestingdetail.getVisibility()==View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(harvesting, new AutoTransition());
        harvestingdetail.setVisibility(w);

        int x=(fertidetail.getVisibility()==View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(fertilizer, new AutoTransition());
        fertidetail.setVisibility(x);
    }
}