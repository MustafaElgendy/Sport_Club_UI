package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class ClubActivities extends AppCompatActivity {
    private ArrayList<UserDataRecyclerViewContent> clubActivitiesList = new ArrayList<>();
    private ClubActivitiesAdapter adapter;
    UserDataRecyclerViewContent model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_activities);

        RecyclerView dataRecyclerView = findViewById(R.id.clubActivities_recyclerView);
        adapter = new ClubActivitiesAdapter(clubActivitiesList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dataRecyclerView.setLayoutManager(mLayoutManager);
        dataRecyclerView.setItemAnimator(new DefaultItemAnimator());
        dataRecyclerView.setAdapter(adapter);

        model = new UserDataRecyclerViewContent(R.drawable.activity1, "Water Polo Classes");
        clubActivitiesList.add(model);
        model = new UserDataRecyclerViewContent(R.drawable.activity2, "Egypt Chess Academy");
        clubActivitiesList.add(model);
        model = new UserDataRecyclerViewContent(R.drawable.activity3, "SYNCHRONIZED Swimming Classes for Women");
        clubActivitiesList.add(model);
        model = new UserDataRecyclerViewContent(R.drawable.activity4, "Water Polo");
        clubActivitiesList.add(model);
        model = new UserDataRecyclerViewContent(R.drawable.activity5, "SYNCHRONIZED Swimming Classes for Men");
        clubActivitiesList.add(model);
        model = new UserDataRecyclerViewContent(R.drawable.activity6, "دروس الجيتار والكمان");
        clubActivitiesList.add(model);
        model = new UserDataRecyclerViewContent(R.drawable.activity7, "Water Polo");
        clubActivitiesList.add(model);
        model = new UserDataRecyclerViewContent(R.drawable.activity8, "Robotics Sessions");
        clubActivitiesList.add(model);
        model = new UserDataRecyclerViewContent(R.drawable.activity9, "Music Class");
        clubActivitiesList.add(model);

        ImageView backArrow = findViewById(R.id.backClubActivity_id);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomeIntent = new Intent(ClubActivities.this,BasicHomePageActivity2.class);
                startActivity(HomeIntent);
            }
        });
        RelativeLayout userDataMenu = findViewById(R.id.user_dataID77);
        RelativeLayout paymentsMenu = findViewById(R.id.payments_id7);
        RelativeLayout receiptsMenu = findViewById(R.id.receipts_id7);
        RelativeLayout dataBaseMenu = findViewById(R.id.database_id7);
        RelativeLayout NewsMenu = findViewById(R.id.news_id7);
        RelativeLayout ActivitiesMenu = findViewById(R.id.activities_id7);
        RelativeLayout LogoutMenu = findViewById(R.id.logout_id7);

        paymentsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paymentIntent = new Intent(ClubActivities.this,PaymentActivity.class);
                startActivity(paymentIntent);
            }
        });
        dataBaseMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent UserDataIntent = new Intent(ClubActivities.this,UserDataActivity.class);
                startActivity(UserDataIntent);
            }
        });
        receiptsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ReceiptsIntent = new Intent(ClubActivities.this,ReceiptsActivity.class);
                startActivity(ReceiptsIntent);
            }
        });
        NewsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newsIntent = new Intent(ClubActivities.this,NewsActivity.class);
                startActivity(newsIntent);
            }
        });
        userDataMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clubActivityIntent = new Intent(ClubActivities.this,HomeActivity.class);
                startActivity(clubActivityIntent);
            }
        });

        LogoutMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ClubActivities.this);
                builder.setTitle("Logout");
                builder.setMessage("Are you sure you want to logout ?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent logOutIntent = new Intent(ClubActivities.this,LogInActivity.class);
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