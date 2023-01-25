package com.example.listenupmerchant.models;

import com.google.gson.annotations.SerializedName;

public class ProductUSP{

	@SerializedName("additionalProp1")
	private String additionalProp1;

	@SerializedName("additionalProp3")
	private String additionalProp3;

	@SerializedName("additionalProp2")
	private String additionalProp2;

	public void setAdditionalProp1(String additionalProp1){
		this.additionalProp1 = additionalProp1;
	}

	public String getAdditionalProp1(){
		return additionalProp1;
	}

	public void setAdditionalProp3(String additionalProp3){
		this.additionalProp3 = additionalProp3;
	}

	public String getAdditionalProp3(){
		return additionalProp3;
	}

	public void setAdditionalProp2(String additionalProp2){
		this.additionalProp2 = additionalProp2;
	}

	public String getAdditionalProp2(){
		return additionalProp2;
	}

	@Override
 	public String toString(){
		return 
			"ProductUSP{" + 
			"additionalProp1 = '" + additionalProp1 + '\'' + 
			",additionalProp3 = '" + additionalProp3 + '\'' + 
			",additionalProp2 = '" + additionalProp2 + '\'' + 
			"}";
		}
}