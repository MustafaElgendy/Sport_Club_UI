package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        TextView signInText = findViewById(R.id.sign_in2);
        signInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = new Intent(SignUpActivity.this,LogInActivity.class);
                startActivity(signInIntent);
            }
        });

        EditText membershipNumber = findViewById(R.id.membership_number_id);
        EditText personalIdNumber = findViewById(R.id.personal_id_number);
        Button createAccount1 = findViewById(R.id.sign_up_id);
        createAccount1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String memberNum = membershipNumber.getText().toString();
                String personalNum = personalIdNumber.getText().toString();
                if (memberNum.equals("")||personalNum.equals("")){
                    membershipNumber.setError("يجب ان تكتب رقم العضوية");
                    personalIdNumber.setError("يجب ان تكتب رقم تحقيق الشخصية");
                }else {
                    Intent createPasswordIntent = new Intent(SignUpActivity.this,PasswordActivity.class);
                    startActivity(createPasswordIntent);
                }
            }
        });
    }
}