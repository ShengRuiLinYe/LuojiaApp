package com.example.luojiaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PersonalCenterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_center);
        Button back = (Button) findViewById(R.id.back2);
        Button seller = (Button) findViewById(R.id.seller);
        Button information = (Button) findViewById(R.id.information);
        Button cart = (Button) findViewById(R.id.shopping_cart);
        Button purchased = (Button) findViewById(R.id.purchased);

        // 设置监听按钮的点击, 切换页面
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalCenterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        seller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalCenterActivity.this, SellerActivity.class);
                startActivity(intent);
            }
        });
        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalCenterActivity.this, InformationActivity.class);
                startActivity(intent);
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalCenterActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });
        purchased.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalCenterActivity.this, ItemBoughtActivity.class);
                startActivity(intent);
            }
        });
    }
}
