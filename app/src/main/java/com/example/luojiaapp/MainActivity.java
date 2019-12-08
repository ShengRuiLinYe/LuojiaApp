package com.example.luojiaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Item> ItemList = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_login=(Button)findViewById(R.id.title_login);//和登录绑定
        Button button_search=(Button)findViewById(R.id.search_button);//查找商品的按钮
        final EditText search_name=(EditText)findViewById(R.id.search);//存储商品名字
        initItems(); // 初始化水果数据
        ItemAdapter adapter = new ItemAdapter(MainActivity.this, R.layout.item, ItemList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Item Item = ItemList.get(position);
                Toast.makeText(MainActivity.this, Item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        button_login.setOnClickListener(new View.OnClickListener() {//点击登录按钮触发效果
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        button_search.setOnClickListener(new View.OnClickListener() {//点击登录按钮触发效果
            @Override
            public void onClick(View v) {
                final String item_name= search_name.getText().toString();
                Toast.makeText(MainActivity.this, item_name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initItems() {
        for (int i = 0; i < 2; i++) {
            Item apple = new Item("Apple", R.drawable.apple_pic);
            ItemList.add(apple);
            Item banana = new Item("Banana", R.drawable.banana_pic);
            ItemList.add(banana);
            Item orange = new Item("Orange", R.drawable.orange_pic);
            ItemList.add(orange);
            Item watermelon = new Item("Watermelon", R.drawable.watermelon_pic);
            ItemList.add(watermelon);
            Item pear = new Item("Pear", R.drawable.pear_pic);
            ItemList.add(pear);
            Item grape = new Item("Grape", R.drawable.grape_pic);
            ItemList.add(grape);
            Item pineapple = new Item("Pineapple", R.drawable.pineapple_pic);
            ItemList.add(pineapple);
            Item strawberry = new Item("Strawberry", R.drawable.strawberry_pic);
            ItemList.add(strawberry);
            Item cherry = new Item("Cherry", R.drawable.cherry_pic);
            ItemList.add(cherry);
            Item mango = new Item("Mango", R.drawable.mango_pic);
            ItemList.add(mango);
        }
    }
}
