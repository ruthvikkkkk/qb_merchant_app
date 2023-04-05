package com.example.listenupmerchant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.listenupmerchant.adapter.DashboardStockAdapter;
import com.example.listenupmerchant.models.Merchant;
import com.example.listenupmerchant.models.MerchantGet;
import com.example.listenupmerchant.models.MerchantSignUpModel;
import com.example.listenupmerchant.models.Stock;
import com.example.listenupmerchant.network.MerchantApiInterface;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MerchantDashboard extends AppCompatActivity implements DashboardStockAdapter.IDashboardCommunicator {

    static MerchantGet merchantGet;
    static String merchantId;
    List<Stock> stockList;

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_dashboard);
        MerchantGet myMerchant = new MerchantGet();
        String email = getIntent().getStringExtra("email");

        MyApplication myApplication = (MyApplication) getApplication();
        Retrofit retrofit = myApplication.retrofit;
        MerchantApiInterface merchantApiInterface = retrofit.create(MerchantApiInterface.class);
        SharedPreferences sharedPreference = getSharedPreferences("merchant", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreference.edit();
        Gson gson = new Gson();
        merchantApiInterface.getByEmail(email).enqueue(new Callback<Merchant>() {
            @Override
            public void onResponse(Call<Merchant> call, Response<Merchant> response) {
                Merchant merchant = response.body();
                editor.putString("id", gson.toJson(merchant));
                editor.commit();
                Log.i("data recv", response.body().toString());
            }

            @Override
            public void onFailure(Call<Merchant> call, Throwable t) {

            }
        });

        Merchant merchant = gson.fromJson(sharedPreference.getString("id", null), Merchant.class);
        ((TextView)findViewById(R.id.tv_dashboard_email)).setText(merchant.getEmail());
        ((TextView)findViewById(R.id.tv_dashboard_name)).setText(merchant.getName());
        ((TextView)findViewById(R.id.tv_dashboard_id)).setText(merchant.getMerchantId());

//        merchantId = "ATL2023-01";
        recyclerView = findViewById(R.id.rv_dashboard_stock);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
//        merchantSignUpModel.getMerchantId()
        merchantApiInterface.getAll(merchant.getMerchantId()).enqueue(new Callback<List<Stock>>() {
            @Override
            public void onResponse(Call<List<Stock>> call, Response<List<Stock>> response) {
                List<Stock> myStock = response.body();
                stockList = myStock;
                recyclerView.setAdapter(new DashboardStockAdapter(stockList, MerchantDashboard.this));
//                Log.i("merchant stock", stockList.toString());
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

        MyApplication myApplication = (MyApplication) getApplication();
        Retrofit retrofit = myApplication.retrofit;
        MerchantApiInterface merchantApiInterface = retrofit.create(MerchantApiInterface.class);
        merchantApiInterface.getAll(merchantId).enqueue(new Callback<List<Stock>>() {
            @Override
            public void onResponse(Call<List<Stock>> call, Response<List<Stock>> response) {
                List<Stock> myStock = response.body();
                stockList = myStock;
                recyclerView.setAdapter(new DashboardStockAdapter(stockList, MerchantDashboard.this));
                Log.i("merchant stock", stockList.toString());
            }

            @Override
            public void onFailure(Call<List<Stock>> call, Throwable t) {
                Log.i("merchant stock fail", t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void updateStock(Stock stock) {
        Intent intent = new Intent(getApplicationContext(), MerchantUpdateStock.class);
        intent.putExtra("skuId", stock.getSkuId());
        startActivity(intent);
    }
}