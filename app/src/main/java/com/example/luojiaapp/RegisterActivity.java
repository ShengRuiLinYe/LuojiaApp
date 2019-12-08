package com.example.luojiaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button button1=(Button)findViewById(R.id.submit);
        final EditText password1=(EditText)findViewById(R.id.password1);
        final EditText password2=(EditText)findViewById(R.id.password2);
        password1.setInputType(129);
        password2.setInputType(129);
        EditText name=(EditText)findViewById(R.id.name);
        button1.setOnClickListener(new View.OnClickListener() {//点击登录按钮触发效果
            @Override
            public void onClick(View v) {
                final String pass1=password1.getText().toString();
                final String pass2=password2.getText().toString();
                if(pass1.equals(pass2))
                {
                    Toast.makeText(RegisterActivity.this,"注册成功！",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(RegisterActivity.this,RegisterSucActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(RegisterActivity.this,"两次密码输入不一致！",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
