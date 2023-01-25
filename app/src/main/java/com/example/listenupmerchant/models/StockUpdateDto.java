package com.example.listenupmerchant.models;

import com.google.gson.annotations.SerializedName;

public class StockUpdateDto{

	@SerializedName("quantity")
	private int quantity;

	@SerializedName("price")
	private int price;

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	@Override
 	public String toString(){
		return 
			"StockUpdateDto{" + 
			"quantity = '" + quantity + '\'' + 
			",price = '" + price + '\'' + 
			"}";
		}
}