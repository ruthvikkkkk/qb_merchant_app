package com.example.listenupmerchant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.listenupmerchant.models.ProductCategory;
import com.example.listenupmerchant.models.ProductDto;
import com.example.listenupmerchant.models.ProductUSP;
import com.example.listenupmerchant.models.Stock;
import com.example.listenupmerchant.network.MerchantApiInterface;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MerchantAddProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_add_product);

        MyApplication myApplication = (MyApplication) getApplication();
        Retrofit retrofit = myApplication.retrofit;
        MerchantApiInterface merchantApiInterface = retrofit.create(MerchantApiInterface.class);

        findViewById(R.id.bt_add_product_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected = ((RadioGroup)findViewById(R.id.rg_add_product)).getCheckedRadioButtonId();
                ProductDto productDto = new ProductDto();
                productDto.setProductName(String.valueOf(((EditText)findViewById(R.id.et_add_product_name)).getText()));
                productDto.setProductBrand(String.valueOf(((EditText)findViewById(R.id.et_add_product_brand)).getText()));
                productDto.setProductDescription(String.valueOf(((EditText)findViewById(R.id.et_add_product_description)).getText()));
                productDto.setImageURL(String.valueOf(((EditText)findViewById(R.id.et_add_product_image_url)).getText()));

                ProductCategory productCategory = new ProductCategory();
                productCategory.setCategoryName((((RadioButton)findViewById(selected)).getText()).toString());
                productDto.setProductCategory(productCategory);

                ProductUSP productUSP = new ProductUSP();
                productUSP.setAdditionalProp1(String.valueOf(((Spinner)findViewById(R.id.sp_add_product_high_bass)).getSelectedItem()));
                productUSP.setAdditionalProp2(String.valueOf(((Spinner)findViewById(R.id.sp_add_product_aptx)).getSelectedItem()));
                productUSP.setAdditionalProp3(String.valueOf(((Spinner)findViewById(R.id.sp_add_product_water)).getSelectedItem()));
                merchantApiInterface.addProduct(getIntent().getStringExtra("merchantId"), productDto).enqueue(new Callback<Stock>() {
                    @Override
                    public void onResponse(Call<Stock> call, Response<Stock> response) {
                        if(response.isSuccessful() && response.body() != null){
                            Toast.makeText(myApplication, "Product Added!", Toast.LENGTH_SHORT).show();
                            Log.i("add product response", response.body().toString());
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<Stock> call, Throwable t) {
                        Log.i("add product failure", t.getLocalizedMessage());
                    }
                });
            }
        });
    }
}