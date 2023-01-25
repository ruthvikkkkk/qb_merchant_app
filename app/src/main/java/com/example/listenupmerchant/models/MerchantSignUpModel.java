package com.example.listenupmerchant.models;

import com.google.gson.annotations.SerializedName;

public class MerchantSignUpModel {

	@SerializedName("password")
	private String password;

	@SerializedName("address")
	private String address;

	@SerializedName("phoneNumber")
	private String phoneNumber;

	@SerializedName("modifyDate")
	private String modifyDate;

	@SerializedName("merchantId")
	private String merchantId;

	@SerializedName("name")
	private String name;

	@SerializedName("confirmPassword")
	private String confirmPassword;

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	@SerializedName("createDate")
	private String createDate;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

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

	public void setModifyDate(String modifyDate){
		this.modifyDate = modifyDate;
	}

	public String getModifyDate(){
		return modifyDate;
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

	public void setConfirmPassword(String confirmPassword){
		this.confirmPassword = confirmPassword;
	}

	public String getConfirmPassword(){
		return confirmPassword;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setCreateDate(String createDate){
		this.createDate = createDate;
	}

	public String getCreateDate(){
		return createDate;
	}

	@Override
 	public String toString(){
		return 
			"MerchantSignUpModel{" +
			"password = '" + password + '\'' + 
			",address = '" + address + '\'' + 
			",phoneNumber = '" + phoneNumber + '\'' + 
			",modifyDate = '" + modifyDate + '\'' + 
			",merchantId = '" + merchantId + '\'' + 
			",name = '" + name + '\'' + 
			",confirmPassword = '" + confirmPassword + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			",createDate = '" + createDate + '\'' + 
			"}";
		}
}