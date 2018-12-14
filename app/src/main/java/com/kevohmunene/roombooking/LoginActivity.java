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
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;
    private TextView userRegistration;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Name=findViewById(R.id.etName);
        Password=findViewById(R.id.etPassword);
        Info=findViewById(R.id.tvInfo);
        Login=findViewById(R.id.btnLogin);
        userRegistration=findViewById(R.id.tvRegister);

        Info.setText("No of attempts remaining: 5");

        firebaseAuth =FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);

        FirebaseUser user=firebaseAuth.getCurrentUser();

//        if (user != null){
//            finish();
//            startActivity(new Intent(getApplicationContext(),SelectActivity.class));
//        }



        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=Name.getText().toString().trim();
                String upass=Password.getText().toString().trim();
               if (uname.isEmpty()||upass.isEmpty()){
                   Toast.makeText(LoginActivity.this, "Input all fields", Toast.LENGTH_SHORT).show();
               }else{
                   validate(uname,upass);
               }
            }
        });
       userRegistration.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
           }
       });

    }

    private void validate(String userName, String userPassword) {
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
              if (task.isSuccessful()){
                  progressDialog.dismiss();
                  Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                  startActivity(new Intent(getApplicationContext(),SelectActivity.class));
                  finish();
              }else{
                  Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                  counter--;
                  Info.setText("No of attempts remaining: " + counter);
                  progressDialog.dismiss();
                  if (counter == 0) {
                      Login.setEnabled(false);
                  }
              }
            }
        });


    }
}
