package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.transition.Transition;

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

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RelativeLayout payment = findViewById(R.id.receivables_button);
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paymentIntent = new Intent(HomeActivity.this,PaymentActivity.class);
                startActivity(paymentIntent);
            }
        });
        ImageView backArrowButton = findViewById(R.id.backMemberData_id);
        backArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LogInIntent = new Intent(HomeActivity.this,BasicHomePageActivity2.class);
                startActivity(LogInIntent);
            }
        });

        RelativeLayout userDataMenu = findViewById(R.id.user_dataID22);
        RelativeLayout paymentsMenu = findViewById(R.id.payments_id2);
        RelativeLayout receiptsMenu = findViewById(R.id.receipts_id2);
        RelativeLayout dataBaseMenu = findViewById(R.id.database_id2);
        RelativeLayout NewsMenu = findViewById(R.id.news_id2);
        RelativeLayout ActivitiesMenu = findViewById(R.id.activities_id2);
        RelativeLayout LogoutMenu = findViewById(R.id.logout_id2);

        paymentsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paymentIntent = new Intent(HomeActivity.this,PaymentActivity.class);
                startActivity(paymentIntent);
            }
        });
        dataBaseMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent UserDataIntent = new Intent(HomeActivity.this,UserDataActivity.class);
                startActivity(UserDataIntent);
            }
        });
        receiptsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ReceiptsIntent = new Intent(HomeActivity.this,ReceiptsActivity.class);
                startActivity(ReceiptsIntent);
            }
        });
        NewsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newsIntent = new Intent(HomeActivity.this,NewsActivity.class);
                startActivity(newsIntent);
            }
        });
        ActivitiesMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clubActivityIntent = new Intent(HomeActivity.this,ClubActivities.class);
                startActivity(clubActivityIntent);
            }
        });

        LogoutMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
                builder.setTitle("Logout");
                builder.setMessage("Are you sure you want to logout ?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent logOutIntent = new Intent(HomeActivity.this,LogInActivity.class);
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