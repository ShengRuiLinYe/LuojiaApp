package com.example.luojiaapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.jar.Attributes;

public class ItemInformation extends AppCompatActivity {
    private String Name;
    private int ImageId2;
    private int Price;
    private int Sales;


    private static final String TAG = "ItemInformation";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_information);
        Intent intent = getIntent();
        Name = intent.getStringExtra("Name");
        ImageId2 = intent.getIntExtra("ImageId2", -1);
        Price = intent.getIntExtra("Price", -1);
        Sales = intent.getIntExtra("Sales", -1);

        Log.d(TAG, "onCreate: read the intent data");
        Log.d(TAG, "onCreate: "+Name);
        Log.d(TAG, "onCreate: "+(ImageId2));
        Log.d(TAG, "onCreate: "+Price);
        Log.d(TAG, "onCreate: "+Sales);

        TextView price_textview = (TextView)findViewById(R.id.item_price);
        TextView sales_textview = (TextView)findViewById(R.id.item_sales);
        TextView name_textview = (TextView)findViewById(R.id.item_description);
        ImageView item_image = (ImageView)findViewById(R.id.image_item2);

        price_textview.setText(String.valueOf(Price));
        sales_textview.setText(String.valueOf(Sales));
        name_textview.setText(String.valueOf(Name));
        item_image.setImageResource(ImageId2);

    }
}
