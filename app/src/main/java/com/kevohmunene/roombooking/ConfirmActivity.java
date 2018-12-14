package com.kevohmunene.roombooking;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ConfirmActivity extends AppCompatActivity {
    Button calling,mailing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        mailing=findViewById(R.id.btnemail);


//        calling.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent piga=new Intent(Intent.ACTION_CALL);
//                piga.setData(Uri.parse("tel:0712345678"));
//                startActivity(piga);
//            }
//        });
        mailing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendMail = new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto","kevohneneeh1@gmail.com","null"));
                sendMail.putExtra(Intent.EXTRA_SUBJECT,"ROOM CHECK AVAILABILITY");
                sendMail.putExtra(Intent.EXTRA_TEXT,"Hello! Can you please check availability for the room in the Hotel.Thankyou");
                startActivity(sendMail);
            }
        });
    }
}
