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

public class NewsActivity extends AppCompatActivity {
    private ArrayList<UserDataRecyclerViewContent> newsList = new ArrayList<>();
    private ClubActivitiesAdapter adapter;
    UserDataRecyclerViewContent model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        RecyclerView dataRecyclerView = findViewById(R.id.news_recyclerView);
        adapter = new ClubActivitiesAdapter(newsList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dataRecyclerView.setLayoutManager(mLayoutManager);
        dataRecyclerView.setItemAnimator(new DefaultItemAnimator());
        dataRecyclerView.setAdapter(adapter);

        model = new UserDataRecyclerViewContent(R.drawable.news1, "إعادة فتح حمام السباحة المغطى");
        newsList.add(model);
        model = new UserDataRecyclerViewContent(R.drawable.news2, "زيارة كابتن روبرتو جارسيا مدير منتخب مصر لكرة اليد لنادى الرحاب");
        newsList.add(model);
        model = new UserDataRecyclerViewContent(R.drawable.news3, "");
        newsList.add(model);
        model = new UserDataRecyclerViewContent(R.drawable.news4, "SYNC Now Breath Later");
        newsList.add(model);
        model = new UserDataRecyclerViewContent(R.drawable.news5, "إختبار التقييم لكرة الماء والباليه المائى");
        newsList.add(model);
        model = new UserDataRecyclerViewContent(R.drawable.news6, "إعلان نادى الرحاب الرياضى بالتعاون مع أكاديمية REHABFUTSAL");
        newsList.add(model);
        model = new UserDataRecyclerViewContent(R.drawable.news7, "تأهيل الاطفال لدخول عالم الباليه");
        newsList.add(model);
        model = new UserDataRecyclerViewContent(R.drawable.news8, "هام لأعضاء نادى الرحاب");
        newsList.add(model);

        ImageView backArrow = findViewById(R.id.backNews_id);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomeIntent = new Intent(NewsActivity.this,BasicHomePageActivity2.class);
                startActivity(HomeIntent);
            }
        });
        RelativeLayout userDataMenu = findViewById(R.id.user_dataID66);
        RelativeLayout paymentsMenu = findViewById(R.id.payments_id6);
        RelativeLayout receiptsMenu = findViewById(R.id.receipts_id6);
        RelativeLayout dataBaseMenu = findViewById(R.id.database_id6);
        RelativeLayout NewsMenu = findViewById(R.id.news_id6);
        RelativeLayout ActivitiesMenu = findViewById(R.id.activities_id6);
        RelativeLayout LogoutMenu = findViewById(R.id.logout_id6);

        paymentsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paymentIntent = new Intent(NewsActivity.this,PaymentActivity.class);
                startActivity(paymentIntent);
            }
        });
        dataBaseMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent UserDataIntent = new Intent(NewsActivity.this,UserDataActivity.class);
                startActivity(UserDataIntent);
            }
        });
        receiptsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ReceiptsIntent = new Intent(NewsActivity.this,ReceiptsActivity.class);
                startActivity(ReceiptsIntent);
            }
        });
        userDataMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newsIntent = new Intent(NewsActivity.this,HomeActivity.class);
                startActivity(newsIntent);
            }
        });
        ActivitiesMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clubActivityIntent = new Intent(NewsActivity.this,ClubActivities.class);
                startActivity(clubActivityIntent);
            }
        });

        LogoutMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(NewsActivity.this);
                builder.setTitle("Logout");
                builder.setMessage("Are you sure you want to logout ?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent logOutIntent = new Intent(NewsActivity.this,LogInActivity.class);
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
