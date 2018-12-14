package com.kevohmunene.roombooking;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class BookingActivity extends AppCompatActivity {


    private static final String TAG = "BookingActivity";

    private TextView checkIn, checkOut,rooms,adults,children,name,email,number;
    private Button save;
    private DatePickerDialog.OnDateSetListener mDateSetListener1,mDateSetListener12;
   private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        checkIn =findViewById(R.id.tvDate);
        checkOut =findViewById(R.id.tvDatetwo);
        rooms=findViewById(R.id.edtroom);
        adults=findViewById(R.id.edtadult);
        children=findViewById(R.id.edtchildren);
        name=findViewById(R.id.edtName);
        email=findViewById(R.id.edtmail);
        number=findViewById(R.id.edtphone);
        save =findViewById(R.id.btnsave);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Booking\nPlease Wait...");
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        BookingActivity.this,
                        android.R.style.Theme_Holo_Dialog_NoActionBar_MinWidth,
                        mDateSetListener1,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet:mm/dd/yyy "+month  + "/" + day + "/" + year);
                String date = month + "/" + day + "/" + year;
                checkIn.setText(date);

            }
        };


        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        BookingActivity.this,
                        android.R.style.Theme_Holo_Dialog_NoActionBar_MinWidth,
                        mDateSetListener12,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener12 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet:mm/dd/yyy "+month  + "/" + day + "/" + year);
                String date1 = month + "/" + day + "/" + year;
                checkOut.setText(date1);

            }
        };

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ingia = checkIn.getText().toString();
                String toka = checkOut.getText().toString();
                String nyumba = rooms.getText().toString();
                String wakubwa =adults.getText().toString();
                String wadogo =children.getText().toString();
                String jina = name.getText().toString();
                String arafa = email.getText().toString();
                String simu = number.getText().toString();
                //check if the user has filled the details
                if (ingia.isEmpty()||toka.isEmpty()||nyumba.isEmpty()||wakubwa.isEmpty()||wadogo.isEmpty()||jina.isEmpty()||arafa.isEmpty()||simu.isEmpty()){
                    Toast.makeText(BookingActivity.this, "Fill All Inputs", Toast.LENGTH_SHORT).show();
                }else {
                    //time
                    long time = System.currentTimeMillis();
                    DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("Users/"+time);
                    ItemAdapter x = new ItemAdapter(ingia,toka,nyumba,wakubwa,wadogo,jina,arafa,simu);
                    dialog.show();
                    ref.setValue(x).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            dialog.dismiss();
                            if (task.isSuccessful()){
                                Toast.makeText(BookingActivity.this, "Booking Successful", Toast.LENGTH_SHORT).show();
                                checkIn.setText("");
                                checkOut.setText("");
                                rooms.setText("");
                                adults.setText("");
                                children.setText("");
                                name.setText("");
                                email.setText("");
                                number.setText("");
                                finish();
                                startActivity(new Intent(getApplicationContext(),SelectActivity.class));

                            }else {
                                Toast.makeText(BookingActivity.this, "Booking Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
    }
}
