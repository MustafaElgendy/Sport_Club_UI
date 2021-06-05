package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_layout);

        Button createAccount = findViewById(R.id.create_account_id);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUpIntent = new Intent(LogInActivity.this,SignUpActivity.class);
                startActivity(signUpIntent);
            }
        });

        Button LogInButton = findViewById(R.id.logIn_button);
        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(LogInActivity.this,BasicHomePageActivity2.class);
                startActivity(homeIntent);
            }
        });

        TextView textView = findViewById(R.id.textView2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this,RetrofitTest.class);
                startActivity(intent);
            }
        });
    }
}