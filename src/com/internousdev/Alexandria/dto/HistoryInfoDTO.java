package com.internousdev.Alexandria.dto;

import java.util.Date;

public class HistoryInfoDTO {
	private int id;
	private String userId;
	private int productId;
	private String productName;
	private String productImage;
	private String releaseCompany;
	private Date releaseDate;
	private int subTotal;
	private int productCount;
	private int price;
	private int addressId;
	private int cartId;
	private Date insertDate;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getUserId(){
		return userId;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public int getProductId(){
		return productId;
	}

	public void setProductId(int productId){
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String  getReleaseCompany() {
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	public Date getReleaseDate(){
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate){
		this.releaseDate = releaseDate;
	}

	public int getProductCount(){
		return productCount;
	}

	public void setProductCount(int productCount){
		this.productCount = productCount;
	}

	public int getPrice(){
		return price;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getAddressId(){
		return addressId;
	}

	public void setAddressId(int addressId){
		this.addressId = addressId;
	}

	public int getSubTotal(){
		return subTotal;
	}

	public void setSubTotal(int subTotal){
		this.subTotal = subTotal;
	}

	public int getCartId(){
		return cartId;
	}

	public void setCartId(int cartId){
		this.cartId = cartId;
	}

	public Date getInsertDate(){
		return insertDate;
	}

	public void setInsertDate(Date insertDate){
		this.insertDate = insertDate;
	}
}
