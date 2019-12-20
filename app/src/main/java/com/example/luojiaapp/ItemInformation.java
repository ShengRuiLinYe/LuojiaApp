package com.example.luojiaapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.jar.Attributes;

public class ItemInformation extends AppCompatActivity {
    public static Item item;        // 全局变量传递信息, 表示当前要显示的 item 信息
    private static final String TAG = "ItemInformation";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_information);

        TextView price_textview = (TextView)findViewById(R.id.item_price);
        TextView sales_textview = (TextView)findViewById(R.id.item_sales);
        TextView name_textview = (TextView)findViewById(R.id.item_description);
        ImageView item_image = (ImageView)findViewById(R.id.image_item2);

        name_textview.setText(item.getName());
        price_textview.setText(String.valueOf(item.getPrice()));
        sales_textview.setText(String.valueOf(item.getAmount()));
        item_image.setImageBitmap(item.getBitmap());
    }
}
