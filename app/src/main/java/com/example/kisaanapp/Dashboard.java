
package com.example.kisaanapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {

    CardView croppractices,cropcare,soiltesting,weather,market,cropadvisory;
    ImageView logout;
    FirebaseAuth mAuth;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        if (getActionBar()!= null)
        {
            getActionBar().hide();
        }


        croppractices=(CardView)findViewById(R.id.croppractices);
        cropcare=(CardView)findViewById(R.id.cropcare);
        soiltesting=(CardView)findViewById(R.id.soiltesting);
        weather=(CardView)findViewById(R.id.weather);
        market=(CardView)findViewById(R.id.market);
        cropadvisory=(CardView)findViewById(R.id.cropadvisory);
        bottomNavigationView = findViewById(R.id.bottomnavigation);
        mAuth=FirebaseAuth.getInstance();
        logout=findViewById(R.id.logout);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.about:
                        Intent about = new Intent(Dashboard.this,Aboutus.class);
                        startActivity(about);

                    case R.id.contactus:
                        Intent contact = new Intent(Dashboard.this,Contactus.class);
                        startActivity(contact);


                }
                return true;
            }
        });




        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               gotoUrl("https://weather.com");
            }
        });
        cropadvisory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Calling", Toast.LENGTH_LONG).show();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:9265966434"));
                startActivity(callIntent);
            }

        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                signOutUser();
            }
        });

        croppractices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard.this, croppractices.class);
                startActivity(i);
            }
        });

        cropcare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard.this, cropcare.class);
                startActivity(i);
            }
        });


        soiltesting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard.this, soiltesting.class);
                startActivity(i);
            }
        });

        market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dashboard.this, market.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return true;
    }


    private void gotoUrl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW));
    }

   private void signOutUser() {
        Intent mainActivity=new Intent(Dashboard.this,login.class);
        mainActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainActivity);
        finish();
    }



}
