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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDataActivity extends AppCompatActivity {
    private ArrayList<UserDataRecyclerViewContent> userDataList = new ArrayList<>();
    private ArrayList<UserDataRecyclerViewContent> userDataList2 = new ArrayList<>();
    private UserDataRecyclerViewAdapter adapter;
    UserDataRecyclerViewContent model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        RecyclerView dataRecyclerView = findViewById(R.id.userData_list);
        adapter = new UserDataRecyclerViewAdapter(userDataList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mLayoutManager.setReverseLayout(true);
        dataRecyclerView.setLayoutManager(mLayoutManager);
        dataRecyclerView.setItemAnimator(new DefaultItemAnimator());
        dataRecyclerView.setAdapter(adapter);

        model = new UserDataRecyclerViewContent("الاسم", "مصطفى احمد الجندى");
        userDataList.add(model);
        model = new UserDataRecyclerViewContent("اساس العضوية", "عضو حسب النظام");
        userDataList.add(model);
        model = new UserDataRecyclerViewContent("تاريخ الميلاد", "01/11/03");
        userDataList.add(model);
        model = new UserDataRecyclerViewContent("درجة القرابة", "");
        userDataList.add(model);
        model = new UserDataRecyclerViewContent("العملية", "تجديد سنوى");
        userDataList.add(model);
        model = new UserDataRecyclerViewContent("حساب ل", "بند اشتراك");
        userDataList.add(model);
        model = new UserDataRecyclerViewContent("نوع التحويل", "");
        userDataList.add(model);
        model = new UserDataRecyclerViewContent("العام المالى", "2020");
        userDataList.add(model);
        model = new UserDataRecyclerViewContent("القيمة", "605.00");
        userDataList.add(model);
        model = new UserDataRecyclerViewContent("التارخ", "2/11/2020");
        userDataList.add(model);
        model = new UserDataRecyclerViewContent("سداد", "تم");
        userDataList.add(model);

        RecyclerView dataRecyclerView2 = findViewById(R.id.userData_list2);
        adapter = new UserDataRecyclerViewAdapter(userDataList2);
        LinearLayoutManager mLayoutManager2 = new LinearLayoutManager(getApplicationContext());
        mLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        mLayoutManager2.setReverseLayout(true);
        dataRecyclerView2.setLayoutManager(mLayoutManager2);
        dataRecyclerView2.setItemAnimator(new DefaultItemAnimator());
        dataRecyclerView2.setAdapter(adapter);

        model = new UserDataRecyclerViewContent("الاسم", "مصطفى احمد الجندى");
        userDataList2.add(model);
        model = new UserDataRecyclerViewContent("اساس العضوية", "عضو حسب النظام");
        userDataList2.add(model);
        model = new UserDataRecyclerViewContent("تاريخ الميلاد", "01/11/03");
        userDataList2.add(model);
        model = new UserDataRecyclerViewContent("درجة القرابة", "");
        userDataList2.add(model);
        model = new UserDataRecyclerViewContent("العملية", "غرامات");
        userDataList2.add(model);
        model = new UserDataRecyclerViewContent("حساب ل", "غرامة");
        userDataList2.add(model);
        model = new UserDataRecyclerViewContent("نوع التحويل", "غرامة تأخير السنة الأولى");
        userDataList2.add(model);
        model = new UserDataRecyclerViewContent("العام المالى", "2020");
        userDataList2.add(model);
        model = new UserDataRecyclerViewContent("القيمة", "150.00");
        userDataList2.add(model);
        model = new UserDataRecyclerViewContent("التارخ", "2/7/2020");
        userDataList2.add(model);
        model = new UserDataRecyclerViewContent("سداد", "تم");
        userDataList2.add(model);

        ImageView backArrow = findViewById(R.id.backUserData_id);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomeIntent = new Intent(UserDataActivity.this,BasicHomePageActivity2.class);
                startActivity(HomeIntent);
            }
        });
        RelativeLayout userDataMenu = findViewById(R.id.user_dataID55);
        RelativeLayout paymentsMenu = findViewById(R.id.payments_id5);
        RelativeLayout receiptsMenu = findViewById(R.id.receipts_id5);
        RelativeLayout dataBaseMenu = findViewById(R.id.database_id5);
        RelativeLayout NewsMenu = findViewById(R.id.news_id5);
        RelativeLayout ActivitiesMenu = findViewById(R.id.activities_id5);
        RelativeLayout LogoutMenu = findViewById(R.id.logout_id5);

        paymentsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paymentIntent = new Intent(UserDataActivity.this,PaymentActivity.class);
                startActivity(paymentIntent);
            }
        });
        userDataMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent UserDataIntent = new Intent(UserDataActivity.this,HomeActivity.class);
                startActivity(UserDataIntent);
            }
        });
        receiptsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ReceiptsIntent = new Intent(UserDataActivity.this,ReceiptsActivity.class);
                startActivity(ReceiptsIntent);
            }
        });
        NewsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newsIntent = new Intent(UserDataActivity.this,NewsActivity.class);
                startActivity(newsIntent);
            }
        });
        ActivitiesMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clubActivityIntent = new Intent(UserDataActivity.this,ClubActivities.class);
                startActivity(clubActivityIntent);
            }
        });

        LogoutMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(UserDataActivity.this);
                builder.setTitle("Logout");
                builder.setMessage("Are you sure you want to logout ?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent logOutIntent = new Intent(UserDataActivity.this,LogInActivity.class);
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