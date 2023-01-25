package com.example.listenupmerchant.models;

import com.google.gson.annotations.SerializedName;

public class Stock{

	@SerializedName("image")
	private String image;

	@SerializedName("quantity")
	private int quantity;

	@SerializedName("modifyDate")
	private String modifyDate;

	@SerializedName("productId")
	private String productId;

	@SerializedName("price")
	private int price;

	@SerializedName("merchant")
	private Merchant merchant;

	@SerializedName("productName")
	private String productName;

	@SerializedName("skuId")
	private String skuId;

	@SerializedName("createDate")
	private String createDate;

	public String getImage(){
		return image;
	}

	public int getQuantity(){
		return quantity;
	}

	public String getModifyDate(){
		return modifyDate;
	}

	public String getProductId(){
		return productId;
	}

	public int getPrice(){
		return price;
	}

	public Merchant getMerchant(){
		return merchant;
	}

	public String getProductName(){
		return productName;
	}

	public String getSkuId(){
		return skuId;
	}

	public String getCreateDate(){
		return createDate;
	}
}