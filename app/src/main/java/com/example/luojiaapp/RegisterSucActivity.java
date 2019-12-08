package com.example.luojiaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterSucActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_suc);
        TextView show=(TextView)findViewById(R.id.reg_account);
        String account=getAccount();
        show.setText(account);
        Toast.makeText(RegisterSucActivity.this,show.getText().toString(),Toast.LENGTH_LONG).show();
        Button back=(Button)findViewById(R.id.reg_back);
        back.setOnClickListener(new View.OnClickListener() {//点击登录按钮触发效果
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterSucActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    String getAccount()
    {
        return "3252525361";
    }
}
