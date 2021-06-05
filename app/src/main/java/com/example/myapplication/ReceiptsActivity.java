package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.material.navigation.NavigationView;

public class ReceiptsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipts);


        ImageView backArrowButton = findViewById(R.id.backReceipt_id);
        backArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LogInIntent = new Intent(ReceiptsActivity.this,BasicHomePageActivity2.class);
                startActivity(LogInIntent);
            }
        });
        RelativeLayout userDataMenu = findViewById(R.id.user_dataID44);
        RelativeLayout paymentsMenu = findViewById(R.id.payments_id4);
        RelativeLayout receiptsMenu = findViewById(R.id.receipts_id4);
        RelativeLayout dataBaseMenu = findViewById(R.id.database_id4);
        RelativeLayout NewsMenu = findViewById(R.id.news_id4);
        RelativeLayout ActivitiesMenu = findViewById(R.id.activities_id4);
        RelativeLayout LogoutMenu = findViewById(R.id.logout_id4);

        paymentsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paymentIntent = new Intent(ReceiptsActivity.this,PaymentActivity.class);
                startActivity(paymentIntent);
            }
        });
        dataBaseMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent UserDataIntent = new Intent(ReceiptsActivity.this,UserDataActivity.class);
                startActivity(UserDataIntent);
            }
        });
        userDataMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ReceiptsIntent = new Intent(ReceiptsActivity.this,HomeActivity.class);
                startActivity(ReceiptsIntent);
            }
        });
        NewsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newsIntent = new Intent(ReceiptsActivity.this,NewsActivity.class);
                startActivity(newsIntent);
            }
        });
        ActivitiesMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clubActivityIntent = new Intent(ReceiptsActivity.this,ClubActivities.class);
                startActivity(clubActivityIntent);
            }
        });

        LogoutMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ReceiptsActivity.this);
                builder.setTitle("Logout");
                builder.setMessage("Are you sure you want to logout ?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent logOutIntent = new Intent(ReceiptsActivity.this,LogInActivity.class);
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