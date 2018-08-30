package com.internousdev.Alexandria.action;

import com.opensymphony.xwork2.ActionSupport;

public class CreateReviewAction extends ActionSupport{

	private int productId;

	public String execute(){
		System.out.println(productId);
		return SUCCESS;
	}

	public int getProductId(){
		return productId;
	}

	public void setProductId(int productId){
		this.productId = productId;
	}
}
