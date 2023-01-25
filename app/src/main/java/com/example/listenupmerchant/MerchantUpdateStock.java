package com.example.listenupmerchant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.listenupmerchant.models.StockUpdateDto;

public class MerchantUpdateStock extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_update_stock);

        String skuId = getIntent().getStringExtra("skuId");
        ((TextView)findViewById(R.id.tv_update_stock_skuid)).setText(skuId);
        findViewById(R.id.bt_update_stock_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StockUpdateDto stockUpdateDto = new StockUpdateDto();
                stockUpdateDto.setPrice(Integer.parseInt(String.valueOf(((EditText) findViewById(R.id.et_update_stock_price)).getText())));
                stockUpdateDto.setQuantity(Integer.parseInt(String.valueOf(((EditText) findViewById(R.id.et_update_stock_qty)).getText())));
            }
        });
    }
}