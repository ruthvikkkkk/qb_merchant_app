package com.example.listenupmerchant.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Merchant implements Serializable {

	@SerializedName("address")
	private String address;

	@SerializedName("phoneNumber")
	private String phoneNumber;

	@SerializedName("modifyDate")
	private String modifyDate;

	@SerializedName("merchantId")
	private String merchantId;

	@SerializedName("deleteStatus")
	private boolean deleteStatus;

	@SerializedName("name")
	private String name;

	@SerializedName("rating")
	private int rating;

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	@SerializedName("createDate")
	private String createDate;

	public String getAddress(){
		return address;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public String getModifyDate(){
		return modifyDate;
	}

	public String getMerchantId(){
		return merchantId;
	}

	public boolean isDeleteStatus(){
		return deleteStatus;
	}

	public String getName(){
		return name;
	}

	public int getRating(){
		return rating;
	}

	public int getId(){
		return id;
	}

	public String getEmail(){
		return email;
	}

	public String getCreateDate(){
		return createDate;
	}
}