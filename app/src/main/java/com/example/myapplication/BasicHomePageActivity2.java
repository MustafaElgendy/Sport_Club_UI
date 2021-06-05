package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class BasicHomePageActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_home_page2);
        ImageButton userData = findViewById(R.id.userDataButton);
        ImageButton payments = findViewById(R.id.paymentButton);
        ImageButton Database = findViewById(R.id.dataBaseButton);
        ImageButton receipts = findViewById(R.id.receiptsButton5);
        ImageButton News = findViewById(R.id.newsButton);
        ImageButton Activities = findViewById(R.id.activitiesButton6);
        ImageButton backArrow = findViewById(R.id.backArrowButton7);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasicHomePageActivity2.this,LogInActivity.class);
                startActivity(intent);
            }
        });

        userData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasicHomePageActivity2.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        payments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paymentIntent = new Intent(BasicHomePageActivity2.this,PaymentActivity.class);
                startActivity(paymentIntent);
            }
        });
        Database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent UserDataIntent = new Intent(BasicHomePageActivity2.this,UserDataActivity.class);
                startActivity(UserDataIntent);
            }
        });
        receipts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ReceiptsIntent = new Intent(BasicHomePageActivity2.this,ReceiptsActivity.class);
                startActivity(ReceiptsIntent);
            }
        });
        News.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newsIntent = new Intent(BasicHomePageActivity2.this,NewsActivity.class);
                startActivity(newsIntent);
            }
        });
        Activities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clubActivityIntent = new Intent(BasicHomePageActivity2.this,ClubActivities.class);
                startActivity(clubActivityIntent);
            }
        });

        RelativeLayout userDataMenu = findViewById(R.id.user_dataID2);
        RelativeLayout paymentsMenu = findViewById(R.id.payments_id);
        RelativeLayout receiptsMenu = findViewById(R.id.receipts_id);
        RelativeLayout dataBaseMenu = findViewById(R.id.database_id);
        RelativeLayout NewsMenu = findViewById(R.id.news_id);
        RelativeLayout ActivitiesMenu = findViewById(R.id.activities_id);
        RelativeLayout LogoutMenu = findViewById(R.id.logout_id);

        userDataMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasicHomePageActivity2.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        paymentsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paymentIntent = new Intent(BasicHomePageActivity2.this,PaymentActivity.class);
                startActivity(paymentIntent);
            }
        });
        dataBaseMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent UserDataIntent = new Intent(BasicHomePageActivity2.this,UserDataActivity.class);
                startActivity(UserDataIntent);
            }
        });
        receiptsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ReceiptsIntent = new Intent(BasicHomePageActivity2.this,ReceiptsActivity.class);
                startActivity(ReceiptsIntent);
            }
        });
        NewsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newsIntent = new Intent(BasicHomePageActivity2.this,NewsActivity.class);
                startActivity(newsIntent);
            }
        });
        ActivitiesMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clubActivityIntent = new Intent(BasicHomePageActivity2.this,ClubActivities.class);
                startActivity(clubActivityIntent);
            }
        });

        LogoutMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(BasicHomePageActivity2.this);
                builder.setTitle("Logout");
                builder.setMessage("Are you sure you want to logout ?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent logOutIntent = new Intent(BasicHomePageActivity2.this,LogInActivity.class);
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