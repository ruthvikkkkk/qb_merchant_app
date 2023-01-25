package com.example.listenupmerchant.models;

import com.google.gson.annotations.SerializedName;

public class ProductDto{

	@SerializedName("createdDate")
	private String createdDate;

	@SerializedName("updatedBy")
	private String updatedBy;

	@SerializedName("productID")
	private String productID;

	@SerializedName("createdBy")
	private String createdBy;

	@SerializedName("deleteStatus")
	private boolean deleteStatus;

	@SerializedName("imageURL")
	private String imageURL;

	@SerializedName("productBrand")
	private String productBrand;

	@SerializedName("updatedDate")
	private String updatedDate;

	@SerializedName("productDescription")
	private String productDescription;

	@SerializedName("productName")
	private String productName;

	@SerializedName("productCategory")
	private ProductCategory productCategory;

	@SerializedName("productUSP")
	private ProductUSP productUSP;

	public void setCreatedDate(String createdDate){
		this.createdDate = createdDate;
	}

	public String getCreatedDate(){
		return createdDate;
	}

	public void setUpdatedBy(String updatedBy){
		this.updatedBy = updatedBy;
	}

	public String getUpdatedBy(){
		return updatedBy;
	}

	public void setProductID(String productID){
		this.productID = productID;
	}

	public String getProductID(){
		return productID;
	}

	public void setCreatedBy(String createdBy){
		this.createdBy = createdBy;
	}

	public String getCreatedBy(){
		return createdBy;
	}

	public void setDeleteStatus(boolean deleteStatus){
		this.deleteStatus = deleteStatus;
	}

	public boolean isDeleteStatus(){
		return deleteStatus;
	}

	public void setImageURL(String imageURL){
		this.imageURL = imageURL;
	}

	public String getImageURL(){
		return imageURL;
	}

	public void setProductBrand(String productBrand){
		this.productBrand = productBrand;
	}

	public String getProductBrand(){
		return productBrand;
	}

	public void setUpdatedDate(String updatedDate){
		this.updatedDate = updatedDate;
	}

	public String getUpdatedDate(){
		return updatedDate;
	}

	public void setProductDescription(String productDescription){
		this.productDescription = productDescription;
	}

	public String getProductDescription(){
		return productDescription;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductName(){
		return productName;
	}

	public void setProductCategory(ProductCategory productCategory){
		this.productCategory = productCategory;
	}

	public ProductCategory getProductCategory(){
		return productCategory;
	}

	public void setProductUSP(ProductUSP productUSP){
		this.productUSP = productUSP;
	}

	public ProductUSP getProductUSP(){
		return productUSP;
	}

	@Override
 	public String toString(){
		return 
			"ProductDto{" + 
			"createdDate = '" + createdDate + '\'' + 
			",updatedBy = '" + updatedBy + '\'' + 
			",productID = '" + productID + '\'' + 
			",createdBy = '" + createdBy + '\'' + 
			",deleteStatus = '" + deleteStatus + '\'' + 
			",imageURL = '" + imageURL + '\'' + 
			",productBrand = '" + productBrand + '\'' + 
			",updatedDate = '" + updatedDate + '\'' + 
			",productDescription = '" + productDescription + '\'' + 
			",productName = '" + productName + '\'' + 
			",productCategory = '" + productCategory + '\'' + 
			",productUSP = '" + productUSP + '\'' + 
			"}";
		}
}