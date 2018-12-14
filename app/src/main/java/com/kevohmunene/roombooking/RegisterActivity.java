package com.kevohmunene.roombooking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private EditText userName,userNumber,userEmail,userPassword;
    private  Button regButton;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupUIView();
        dialog = new ProgressDialog(this);
        dialog.setMessage("Registering...");
        firebaseAuth = FirebaseAuth.getInstance();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    //upload data to the database
                    String user_email =userEmail.getText().toString().trim();
                    String user_Password = userPassword.getText().toString().trim();
                    dialog.show();
                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            dialog.dismiss();
                            if (task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                            }else {
                                Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
               startActivity(intent);

            }
        });



    }
    private void setupUIView(){
        userName = findViewById(R.id.edtnameone);
        userNumber = findViewById(R.id.edtnumberone);
        userEmail = findViewById(R.id.edtmail);
        userPassword = findViewById(R.id.edtpassword);
        regButton = findViewById(R.id.btnregister);
        userLogin=findViewById(R.id.textView15);
    }

    private Boolean validate (){
        Boolean result = false;

        String name = userName.getText().toString();
        String email = userEmail.getText().toString();
        String number = userNumber.getText().toString();
        String password = userPassword.getText().toString();

        if (name.isEmpty() || email.isEmpty() || number.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        }else {
            result = true;
        }
        return result;
    }
}