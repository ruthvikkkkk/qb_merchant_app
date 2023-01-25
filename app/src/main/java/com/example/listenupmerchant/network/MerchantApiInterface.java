package com.example.listenupmerchant.network;

import com.example.listenupmerchant.models.MerchantGet;
import com.example.listenupmerchant.models.MerchantSignInModel;
import com.example.listenupmerchant.models.MerchantSignUpModel;
import com.example.listenupmerchant.models.ProductDto;
import com.example.listenupmerchant.models.Stock;
import com.example.listenupmerchant.models.StockUpdateDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MerchantApiInterface {
    @POST("merchant/signIn")
    Call<Integer> signIn(@Body MerchantSignInModel merchantSignIn);

    @POST("merchant/signUp")
    Call<Integer> signUp(@Body MerchantSignUpModel merchantSignUp);

    @GET("merchant/getByEmail/{email}")
    Call<MerchantGet> getByEmail(@Path("email") String email);

    @GET("stock/viewProducts/{merchantId}")
    Call<List<Stock>> getAll(@Path("merchantId") String merchantId);

    @POST("stock/addProduct/{merchantId}")
    Call<Stock> addProduct(@Path("merchantId") String merchantId, @Body ProductDto productDto);

    @POST("stock/updateStock/{skuId}")
    Call<Stock> updateStock(@Path("skuId") String skuId, @Body StockUpdateDto stockUpdateDto);
}