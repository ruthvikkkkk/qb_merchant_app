package com.example.listenupmerchant.models;

import com.google.gson.annotations.SerializedName;

public class MerchantEmailDto{

	@SerializedName("email")
	private String email;

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"MerchantEmailDto{" + 
			"email = '" + email + '\'' + 
			"}";
		}
}