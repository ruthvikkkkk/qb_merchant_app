package com.example.listenupmerchant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listenupmerchant.models.Stock;
import com.example.listenupmerchant.models.StockUpdateDto;
import com.example.listenupmerchant.network.MerchantApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MerchantUpdateStock extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_update_stock);

        MyApplication myApplication = (MyApplication) getApplication();
        Retrofit retrofit = myApplication.retrofit;
        MerchantApiInterface merchantApiInterface = retrofit.create(MerchantApiInterface.class);

        String skuId = getIntent().getStringExtra("skuId");
        ((TextView)findViewById(R.id.tv_update_stock_skuid)).setText(skuId);
        findViewById(R.id.bt_update_stock_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StockUpdateDto stockUpdateDto = new StockUpdateDto();
                stockUpdateDto.setPrice(Integer.parseInt(String.valueOf(((EditText) findViewById(R.id.et_update_stock_price)).getText())));
                stockUpdateDto.setQuantity(Integer.parseInt(String.valueOf(((EditText) findViewById(R.id.et_update_stock_qty)).getText())));
                merchantApiInterface.updateStock(skuId, stockUpdateDto).enqueue(new Callback<Stock>() {
                    @Override
                    public void onResponse(Call<Stock> call, Response<Stock> response) {
                        Toast.makeText(myApplication, "updated!", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Stock> call, Throwable t) {

                    }
                });
            }
        });
    }
}