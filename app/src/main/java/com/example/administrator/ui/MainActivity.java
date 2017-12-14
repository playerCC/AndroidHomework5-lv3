package com.example.administrator.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Editaccount;
    private EditText Editpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        Button button1 = findViewById(R.id.register_0);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        Button button2 = findViewById(R.id.login);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
                Editaccount = findViewById(R.id.edt_1);
                Editpassword = findViewById(R.id.edt_2);
                String name = sharedPreferences.getString("name","");
                String password = sharedPreferences.getString("password","");
                if(Editaccount.getText().toString().equals(name)&&Editpassword.getText().toString().equals(password)){
                    Intent intent = new Intent(MainActivity.this,InformationActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "您输入的账号或密码错误！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
