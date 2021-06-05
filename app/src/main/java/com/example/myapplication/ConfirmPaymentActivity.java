package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class ConfirmPaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_payment);

        ArrayList<String> authentication = new ArrayList<String>();
        authentication.add("(Y) Authentication Successful");
        authentication.add("(A) Authentication Successful");
        authentication.add("(X) Authentication Successful");
        authentication.add("(Z) Authentication Successful");

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,authentication);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinAuthentication = findViewById(R.id.authentication_spinner);
        spinAuthentication.setAdapter(adapter2);

        Button submit = findViewById(R.id.submit_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent receiptIntent = new Intent(ConfirmPaymentActivity.this,ReceiptsActivity.class);
                startActivity(receiptIntent);
            }
        });
    }
}