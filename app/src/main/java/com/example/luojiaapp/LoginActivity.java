package com.example.luojiaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.MissingFormatArgumentException;
import com.example.luojiaapp.LoginStatus;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button back=(Button)findViewById(R.id.back);
        Button register=(Button)findViewById(R.id.register);
        Button login=(Button)findViewById(R.id.login);
        final EditText account=(EditText)findViewById(R.id.account);
        final EditText password=(EditText)findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {//点击登录按钮触发效果
            @Override
            public void onClick(View v) {
                String account1=account.getText().toString();
                String password1=password.getText().toString();
                if(judgePassword(account1,password1)==1)
                {
                    LoginStatus.loggedin = true;
                    LoginStatus.userid = account1;
                    LoginStatus.username = "";      // TODO 从服务器获取用户名
                    Toast.makeText(LoginActivity.this,"登录成功!",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(LoginActivity.this, PersonalCenterActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"密码错误!",Toast.LENGTH_LONG).show();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {//点击返回按钮触发效果
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {//点击注册按钮触发效果
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    public int judgePassword(String account,String password)//判断账号密码是否正确
    {
        if(account.equals("123")&&password.equals("123"))
            return 1;
        else
            return 0;
    }
}
