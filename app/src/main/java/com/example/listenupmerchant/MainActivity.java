package com.example.listenupmerchant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listenupmerchant.models.MerchantSignInModel;
import com.example.listenupmerchant.models.MerchantSignUpModel;
import com.example.listenupmerchant.network.MerchantApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.merchant_login);

        MyApplication myApplication = (MyApplication) getApplication();
        Retrofit retrofit = myApplication.retrofit;
        MerchantApiInterface merchantApiInterface = retrofit.create(MerchantApiInterface.class);
        findViewById(R.id.bt_home_log_in).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = String.valueOf(((EditText)findViewById(R.id.et_home_login_email)).getText());
                String password = String.valueOf(((EditText)findViewById(R.id.et_home_login_password)).getText());
                MerchantSignInModel merchantSignIn = new MerchantSignInModel();
                merchantSignIn.setEmail(email);
                merchantSignIn.setPassword(password);
                merchantApiInterface.signIn(merchantSignIn).enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        int code = response.body();
                        Log.i("RESPONSE", response.body().toString());
                        if(code == 2)
                            Toast.makeText(myApplication, "Incorrect Email!", Toast.LENGTH_SHORT).show();
                        else if(code == 3)
                            Toast.makeText(myApplication, "Incorrect Password!", Toast.LENGTH_SHORT).show();
                        else{
                            Intent intent = new Intent(getApplicationContext(), MerchantDashboard.class);
                            intent.putExtra("email" ,merchantSignIn.getEmail());
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        Log.i("FAILURE", t.getLocalizedMessage());
                    }
                });
            }
        });

        findViewById(R.id.bt_home_sign_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MerchantSignUp.class));
            }
        });
    }
}