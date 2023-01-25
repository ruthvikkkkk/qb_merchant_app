package com.example.listenupmerchant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.listenupmerchant.adapter.DashboardStockAdapter;
import com.example.listenupmerchant.models.Merchant;
import com.example.listenupmerchant.models.MerchantGet;
import com.example.listenupmerchant.models.MerchantSignUpModel;
import com.example.listenupmerchant.models.Stock;
import com.example.listenupmerchant.network.MerchantApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MerchantDashboard extends AppCompatActivity {

    MerchantGet merchantGet;
    List<Stock> stockList;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_dashboard);

        MerchantGet myMerchant = new MerchantGet();
        MyApplication myApplication = (MyApplication) getApplication();
        Retrofit retrofit = myApplication.retrofit;
        MerchantApiInterface merchantApiInterface = retrofit.create(MerchantApiInterface.class);
        String email = getIntent().getStringExtra("email");

        merchantApiInterface.getByEmail(email).enqueue(new Callback<MerchantGet>() {
            @Override
            public void onResponse(Call<MerchantGet> call, Response<MerchantGet> response) {
               merchantGet = response.body();
               merchantGet.setMerchantId(response.body().getMerchantId());
               Log.i("data recv", merchantGet.toString());
            }

            @Override
            public void onFailure(Call<MerchantGet> call, Throwable t) {

            }
        });
//        System.out.println(merchantGet.getMerchantId());
        //Log.i("merchantsignupmodel",merchantSignUpModel.getMerchantId());
//        ((TextView)findViewById(R.id.tv_dashboard_email)).setText(merchantSignUpModel.getEmail());
//        ((TextView)findViewById(R.id.tv_dashboard_name)).setText(merchantSignUpModel.getName());
//        ((TextView)findViewById(R.id.tv_dashboard_id)).setText(merchantSignUpModel.getMerchantId());

        recyclerView = findViewById(R.id.rv_dashboard_stock);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
//        merchantSignUpModel.getMerchantId()
        merchantApiInterface.getAll("RUT2023-01").enqueue(new Callback<List<Stock>>() {
            @Override
            public void onResponse(Call<List<Stock>> call, Response<List<Stock>> response) {
                List<Stock> myStock = response.body();
                stockList = myStock;
                recyclerView.setAdapter(new DashboardStockAdapter(stockList));
                Log.i("merchant stock", stockList.toString());
            }

            @Override
            public void onFailure(Call<List<Stock>> call, Throwable t) {
                Log.i("merchant stock fail", t.getLocalizedMessage());
            }
        });
        findViewById(R.id.bt_dashboard_add_product).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MerchantAddProduct.class);
                intent.putExtra("merchantId", "RUT2023-01");
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}