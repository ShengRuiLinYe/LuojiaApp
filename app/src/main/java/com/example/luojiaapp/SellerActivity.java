package com.example.luojiaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SellerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);
        Button back_to_center=(Button)findViewById(R.id.person_center);
        Button back_to_origin=(Button)findViewById(R.id.back2);
        back_to_center.setOnClickListener(new View.OnClickListener() {//点击登录按钮触发效果
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SellerActivity.this,PersonalCenterActivity.class);
                startActivity(intent);
            }
        });
        back_to_origin.setOnClickListener(new View.OnClickListener() {//点击登录按钮触发效果
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SellerActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
