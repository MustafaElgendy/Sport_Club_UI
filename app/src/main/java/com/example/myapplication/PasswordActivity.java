package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class PasswordActivity extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    //"(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{8,}" +               //at least 8 characters
                    "$");
    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        myDialog = new Dialog(this);
        EditText newPassword = findViewById(R.id.editText_newPassword);
        EditText confirmPassword = findViewById(R.id.editText_confirmPassword);
        Button createAccount = findViewById(R.id.create_account2);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password1 = newPassword.getText().toString();
                String password2 = confirmPassword.getText().toString();

                if (password1.equals("") || password2.equals("")){
                    newPassword.setError("يجب ان تكتب كلمة السر");
                    confirmPassword.setError("يجب ان تأكد كلمة السر");
                }else if (!PASSWORD_PATTERN.matcher(password1).matches()){
                    newPassword.setError("يجب ان لا يقل عن عدد 1 حرف كبير \nو 1 حرف صغير \nو 1 رقم\n و 1 رمز \nو بلا مسافات فارغة \nو ان تكون على الاقل 8 احرف ");
                }
                else if (password1.equals(password2)){
                    myDialog.setContentView(R.layout.activity_condition);
                    Button cancelButton = myDialog.findViewById(R.id.cancel_condition);
                    cancelButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            myDialog.dismiss();
                        }
                    });
                    Button confirmCondition = myDialog.findViewById(R.id.confirm_condition);
                    confirmCondition.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getApplicationContext(), "تم التسجيل بنجاح", Toast.LENGTH_SHORT).show();
                            Intent homeIntent = new Intent(PasswordActivity.this,BasicHomePageActivity2.class);
                            startActivity(homeIntent);
                        }
                    });
                    TextView exitX = myDialog.findViewById(R.id.exit_x);
                    exitX.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            myDialog.dismiss();
                        }
                    });
                    myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
                    myDialog.show();
                }else {
                    confirmPassword.setError("تأكيد كلمة المرور غير مماثل");
                }
            }
        });

        }
    }
