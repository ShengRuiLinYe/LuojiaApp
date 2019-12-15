package com.example.luojiaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddSell extends AppCompatActivity {
    private int category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sell);
        Button button_back = (Button)findViewById(R.id.add_back);
        Button button_add = (Button)findViewById(R.id.add_add);

        final EditText editText_name = (EditText)findViewById(R.id.add_name);
        final EditText editText_price = (EditText)findViewById(R.id.add_price);
        final EditText editText_amount = (EditText)findViewById(R.id.add_amount);

        RadioGroup radioGroup_cate = (RadioGroup)findViewById(R.id.add_radio_group);
        radioGroup_cate.setOnCheckedChangeListener(radioGrouplisten);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int price = -1;
                int amount = -1;
                try {
                    price = Integer.parseInt(editText_price.getText().toString());
                    amount = Integer.parseInt(editText_amount.getText().toString());
                    Item item = new Item(editText_name.getText().toString(),0,0,
                            price,amount,category);

                    //还需要把item真正添加到

                    Toast.makeText(AddSell.this,"添加成功！",Toast.LENGTH_LONG).show();
                    finish();
                }
                catch (NumberFormatException e){
                    Toast.makeText(AddSell.this,"价格和库存应该是整数",Toast.LENGTH_LONG).show();
                    return;
                };
            }
        });

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    private RadioGroup.OnCheckedChangeListener radioGrouplisten = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int id = group.getCheckedRadioButtonId();
            switch (id){
                case R.id.add_cat_book:
                    category = Item.book;
                    break;
                case R.id.add_cat_electric:
                    category = Item.electric;
                    break;
                case R.id.add_cat_life:
                    category = Item.life;
                    break;
                case R.id.add_cat_other:
                    category = Item.other;

                    default:
                        category =Item.other;
                        break;
            }
        }
    };




}
