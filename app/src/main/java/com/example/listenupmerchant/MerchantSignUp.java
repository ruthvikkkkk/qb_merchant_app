package com.example.listenupmerchant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.listenupmerchant.models.MerchantSignUpModel;
import com.example.listenupmerchant.network.MerchantApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MerchantSignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_sign_up);

        MyApplication myApplication = (MyApplication) getApplication();
        Retrofit retrofit = myApplication.retrofit;
        MerchantApiInterface merchantApiInterface = retrofit.create(MerchantApiInterface.class);

        findViewById(R.id.bt_signup_signup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MerchantSignUpModel merchantSignUpModel = new MerchantSignUpModel();
                merchantSignUpModel.setEmail(String.valueOf(((EditText)findViewById(R.id.et_signup_email)).getText()));
                merchantSignUpModel.setName(String.valueOf(((EditText)findViewById(R.id.et_signup_name)).getText()));
                merchantSignUpModel.setAddress(String.valueOf(((EditText)findViewById(R.id.et_signup_address)).getText()));
                merchantSignUpModel.setPhoneNumber(String.valueOf(((EditText)findViewById(R.id.et_signup_phone)).getText()));
                merchantSignUpModel.setPassword(String.valueOf(((EditText)findViewById(R.id.et_signup_password)).getText()));
                merchantSignUpModel.setConfirmPassword(String.valueOf(((EditText)findViewById(R.id.et_signup_confirm_password)).getText()));

                merchantApiInterface.signUp(merchantSignUpModel).enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        int code = response.body().intValue();
                        if(code == 2)
                            Toast.makeText(myApplication, "Email Id Exists!", Toast.LENGTH_SHORT).show();
                        else if(code == 3)
                            Toast.makeText(myApplication, "Passwords do not match!", Toast.LENGTH_SHORT).show();
                        else if(code == 1){
                            Toast.makeText(myApplication, "User Created, Please Login to continue", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        Log.i("RESPONSE", response.body().toString());
                        Log.i("sent data", merchantSignUpModel.toString());
                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        Log.i("FAILURE", t.getStackTrace().toString());
                    }
                });
            }
        });
    }
}