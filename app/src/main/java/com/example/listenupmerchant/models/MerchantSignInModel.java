package com.example.listenupmerchant.models;

import com.google.gson.annotations.SerializedName;

public class MerchantSignInModel {

	@SerializedName("password")
	private String password;

	@SerializedName("email")
	private String email;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"MerchantSignInModel{" +
			"password = '" + password + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}