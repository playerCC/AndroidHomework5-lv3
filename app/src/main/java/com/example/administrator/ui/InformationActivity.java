package com.example.administrator.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by Administrator on 2017/12/12.
 */

public class InformationActivity extends AppCompatActivity {
    private TextView txt_username;
    private TextView txt_phone;
    private TextView txt_password;
    private TextView txt_sex;
    private TextView txt_username1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_layout);
        Button button = findViewById(R.id.backTo_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        txt_username = findViewById(R.id.txt_UserName);
        txt_phone = findViewById(R.id.txt_phone);
        txt_password = findViewById(R.id.txt_Password);
        txt_sex = findViewById(R.id.txt_sex);
        txt_username1 = findViewById(R.id.txt_UserName1);
        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        String username = sharedPreferences.getString("name","");
        String phone = sharedPreferences.getString("phone","");
        String password = sharedPreferences.getString("password","");
        String sex = sharedPreferences.getString("sex","");
        txt_username.setText(username);
        txt_phone.setText(phone);
        txt_password.setText(password);
        txt_sex.setText(sex);
        txt_username1.setText(username);
    }

}
