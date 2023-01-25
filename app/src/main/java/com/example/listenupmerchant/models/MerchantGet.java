package com.example.listenupmerchant.models;

import java.io.Serializable;

public class MerchantGet implements Serializable {
	private String address;
	private String phoneNumber;
	private String merchantId;
	private String name;
	private String email;

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public void setMerchantId(String merchantId){
		this.merchantId = merchantId;
	}

	public String getMerchantId(){
		return merchantId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
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
			"MerchantGet{" + 
			"address = '" + address + '\'' + 
			",phoneNumber = '" + phoneNumber + '\'' + 
			",merchantId = '" + merchantId + '\'' + 
			",name = '" + name + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}
