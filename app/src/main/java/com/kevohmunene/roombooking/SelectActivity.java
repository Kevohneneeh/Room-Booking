package com.kevohmunene.roombooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class SelectActivity extends AppCompatActivity {
    WebView page1;
    Button moja,mbili,tatu,nne,tano,sita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        page1 = findViewById(R.id.web);
        WebSettings settings = page1.getSettings();
        settings.setJavaScriptEnabled(true);
        page1.loadUrl("file:///android_asset/home.html");

        moja=findViewById(R.id.btnone);
        mbili=findViewById(R.id.btntwo);
        tatu=findViewById(R.id.btnthree);
        nne=findViewById(R.id.btnfour);
        tano=findViewById(R.id.btnfive);


        moja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ReservationActivity.class);
                startActivity(intent);
            }
        });

        nne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RoomActivity.class));
            }
        });
        mbili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(getApplicationContext(),RatesActivity.class));
            }
        });
        tatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
        });
        tano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),FacilityActivity.class));
            }
        });

    }

}
