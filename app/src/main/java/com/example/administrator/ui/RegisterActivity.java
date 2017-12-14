package com.example.administrator.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText username;
    private EditText phone;
    private EditText password;
    private Spinner spinnerCardNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        username = findViewById(R.id.edt_1);
        phone = findViewById(R.id.edt_2);
        password = findViewById(R.id.edt_3);
        spinnerCardNumber = findViewById(R.id.spinner_1);
        Button button1 = findViewById(R.id.button_back);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        Button button2 = findViewById(R.id.register);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                String name = username.getText().toString();
                String phonenum = phone.getText().toString();
                String pswd = password.getText().toString();
                String cardNumber = spinnerCardNumber.getSelectedItem().toString();
                editor.putString("name",name);
                editor.putString("phone",phonenum);
                editor.putString("password",pswd);
                editor.putString("sex",cardNumber);
                editor.apply();
                Toast.makeText(RegisterActivity.this,"注册成功!",Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
