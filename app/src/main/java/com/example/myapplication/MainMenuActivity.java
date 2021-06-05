package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainMenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar =findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    private static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.END);
    }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    private static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.END)){
            drawerLayout.closeDrawer(GravityCompat.END);
        }
    }

    public void ClickHome(View view){
        recreate();
    }

    private static void redirectActivity(Activity activity , Class aclass) {

        Intent intent  = new Intent(activity,aclass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_memberData:
                redirectActivity(this,HomeActivity.class);
            Intent memberDataIntent = new Intent(MainMenuActivity.this,HomeActivity.class);
            startActivity(memberDataIntent);
            break;
            case R.id.nav_payment:
                redirectActivity(this,PaymentActivity.class);
                Intent paymentIntent = new Intent(MainMenuActivity.this,PaymentActivity.class);
                startActivity(paymentIntent);
                break;
            case R.id.nav_dataOfYear:
                redirectActivity(this,UserDataActivity.class);
                Intent dataOfYearIntent = new Intent(MainMenuActivity.this,UserDataActivity.class);
                startActivity(dataOfYearIntent);
                break;
            case R.id.nav_receipts:
                redirectActivity(this,ReceiptsActivity.class);
                Intent receiptsIntent = new Intent(MainMenuActivity.this,ReceiptsActivity.class);
                startActivity(receiptsIntent);
                break;
            case R.id.nav_logOut:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainMenuActivity.this);
                builder.setTitle("Logout");
                builder.setMessage("Are you sure you want to logout ?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent logOutIntent = new Intent(MainMenuActivity.this,LogInActivity.class);
                        logOutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(logOutIntent);
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();

                break;
        }
        return true;
    }
}