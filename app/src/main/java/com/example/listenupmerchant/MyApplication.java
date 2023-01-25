package com.example.listenupmerchant;

import android.app.Application;

import com.example.listenupmerchant.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends Application {

    Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient.Builder().build();
        retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.HOST)
                .build();
    }
}
