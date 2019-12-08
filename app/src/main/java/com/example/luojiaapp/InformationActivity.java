package com.example.luojiaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        TextView name=(TextView)findViewById(R.id.user_name_string);
        TextView id=(TextView)findViewById(R.id.user_id_string);
        SharedPreferences sPreferences = getSharedPreferences("config", MODE_PRIVATE);
        String account = sPreferences.getString("account_flag", "");
        Toast.makeText(InformationActivity.this,account,Toast.LENGTH_LONG).show();
        name.setText(account);
        Button back=(Button)findViewById(R.id.back2);
        Button seller=(Button)findViewById(R.id.seller);
        Button information=(Button)findViewById(R.id.information);
        back.setOnClickListener(new View.OnClickListener() {//点击登录按钮触发效果
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InformationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        seller.setOnClickListener(new View.OnClickListener() {//点击登录按钮触发效果
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InformationActivity.this, SellerActivity.class);
                startActivity(intent);
            }
        });
    }
}
