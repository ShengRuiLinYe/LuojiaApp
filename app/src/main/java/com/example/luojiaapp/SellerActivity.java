package com.example.luojiaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SellerActivity extends AppCompatActivity {

    private List<Item> ItemList = new ArrayList<Item>();
    private String name;
    private String phone;

    private static final String TAG = "SellerActivity";
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

        final List<TextView> infos = new ArrayList<>();
        initInfos(infos);

        Button selling = (Button)findViewById(R.id.selling);
        final Button seller_information = (Button) findViewById(R.id.seller_information);


        initItems();
        ItemAdapter adapter = new ItemAdapter(SellerActivity.this, R.layout.item, ItemList);
        final ListView listView = (ListView) findViewById(R.id.list_view_seller);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Item Item = ItemList.get(position);
                Intent intent=new Intent(SellerActivity.this, ItemInformation.class);
                intent.putExtra("ImageId2", Item.getImageId2());
                intent.putExtra("Price", Item.getPrice());
                intent.putExtra("Sales", Item.getSales());
                intent.putExtra("Name",Item.getName());
                Log.d(TAG, "onItemClick: enter the activity");
                startActivity(intent);
            }
        });

        seller_information.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (TextView t : infos) {
                    t.setVisibility(View.VISIBLE);
                }
                listView.setVisibility(View.GONE);
            }
        });

        selling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (TextView t : infos) {
                    t.setVisibility(View.GONE);
                }
                listView.setVisibility(View.VISIBLE);
            }
        });
    }

    // 从登陆信息初始化商人信息的控件列表
    private void initInfos(final List<TextView> infos) {
        infos.add((TextView)findViewById(R.id.SellerName));
        infos.add((TextView)findViewById(R.id.SellerPhone));
        infos.add((TextView)findViewById(R.id.Department));
        infos.add((TextView)findViewById(R.id.School));
        infos.add((TextView)findViewById(R.id.Grade));
        infos.add((TextView)findViewById(R.id.seller_name));
        infos.get(infos.size() - 1).setText(LoginStatus.realname);
        infos.add((TextView)findViewById(R.id.seller_phone));
        infos.get(infos.size() - 1).setText(LoginStatus.contact);
        infos.add((TextView)findViewById(R.id.department));
        infos.get(infos.size() - 1).setText(LoginStatus.department);
        infos.add((TextView)findViewById(R.id.school));
        infos.get(infos.size() - 1).setText(LoginStatus.school);
        infos.add((TextView)findViewById(R.id.grade));
        infos.get(infos.size() - 1).setText(LoginStatus.grade);
    }


    private void initItems() {
        for (int i = 0; i < 2; i++) {
            Item apple = new Item("Apple", R.drawable.apple_pic);
            ItemList.add(apple);
            Item banana = new Item("Banana", R.drawable.banana_pic);
            ItemList.add(banana);
        }
    }
}
