package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Calendar;

public class PaymentActivity extends AppCompatActivity{
    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        myDialog = new Dialog(this);


        myDialog.setContentView(R.layout.activity_credit_card1);
        // fill up years spinner
        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for ( int i = thisYear; i <= 2050; i++){
            years.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,years);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinYear = myDialog.findViewById(R.id.years_spinner);
        spinYear.setAdapter(adapter);
        // fill up months spinner
        ArrayList<String> months = new ArrayList<String>();
        for (int i = 1 ; i <= 12;i++){
            months.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,months);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinMonths = myDialog.findViewById(R.id.months_spinner);
        spinMonths.setAdapter(adapter2);

        // mastercard Button
        ImageButton mastercard = findViewById(R.id.mastercard_button);
         mastercard.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 TextView exitX = myDialog.findViewById(R.id.exit_x_id);
                 exitX.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         myDialog.dismiss();
                     }
                 });
                 Button cancelButton = myDialog.findViewById(R.id.cancel_payment_button);
                 cancelButton.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         myDialog.dismiss();
                     }
                 });
                 Button nextButton = myDialog.findViewById(R.id.next_payment_button);
                 nextButton.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Intent confirmPaymentIntent = new Intent(PaymentActivity.this,ConfirmPaymentActivity.class);
                         startActivity(confirmPaymentIntent);
                     }
                 });
                 ImageView creditView = myDialog.findViewById(R.id.credit_card_imageView);
                 creditView.setImageResource(R.drawable.mastercard1);
                 myDialog.show();
             }
         });
         // visa Button
         ImageButton visaCard = findViewById(R.id.visacard_button);
         visaCard.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 TextView exitX = myDialog.findViewById(R.id.exit_x_id);
                 exitX.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         myDialog.dismiss();
                     }
                 });
                 Button cancelButton = myDialog.findViewById(R.id.cancel_payment_button);
                 cancelButton.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         myDialog.dismiss();
                     }
                 });
                 Button nextButton = myDialog.findViewById(R.id.next_payment_button);
                 nextButton.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Intent confirmPaymentIntent = new Intent(PaymentActivity.this,ConfirmPaymentActivity.class);
                         startActivity(confirmPaymentIntent);
                     }
                 });
                 ImageView creditView = myDialog.findViewById(R.id.credit_card_imageView);
                 creditView.setImageResource(R.drawable.visalago1);
                 myDialog.show();
             }
         });

        ImageView backArrowButton = findViewById(R.id.backPayment_id);
        backArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LogInIntent = new Intent(PaymentActivity.this,BasicHomePageActivity2.class);
                startActivity(LogInIntent);
            }
        });
        RelativeLayout userDataMenu = findViewById(R.id.user_dataID33);
        RelativeLayout paymentsMenu = findViewById(R.id.payments_id3);
        RelativeLayout receiptsMenu = findViewById(R.id.receipts_id3);
        RelativeLayout dataBaseMenu = findViewById(R.id.database_id3);
        RelativeLayout NewsMenu = findViewById(R.id.news_id3);
        RelativeLayout ActivitiesMenu = findViewById(R.id.activities_id3);
        RelativeLayout LogoutMenu = findViewById(R.id.logout_id3);

        userDataMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paymentIntent = new Intent(PaymentActivity.this,HomeActivity.class);
                startActivity(paymentIntent);
            }
        });
        dataBaseMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent UserDataIntent = new Intent(PaymentActivity.this,UserDataActivity.class);
                startActivity(UserDataIntent);
            }
        });
        receiptsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ReceiptsIntent = new Intent(PaymentActivity.this,ReceiptsActivity.class);
                startActivity(ReceiptsIntent);
            }
        });
        NewsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newsIntent = new Intent(PaymentActivity.this,NewsActivity.class);
                startActivity(newsIntent);
            }
        });
        ActivitiesMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clubActivityIntent = new Intent(PaymentActivity.this,ClubActivities.class);
                startActivity(clubActivityIntent);
            }
        });

        LogoutMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PaymentActivity.this);
                builder.setTitle("Logout");
                builder.setMessage("Are you sure you want to logout ?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent logOutIntent = new Intent(PaymentActivity.this,LogInActivity.class);
                        logOutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(logOutIntent);
                        finish();
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });
    }
}