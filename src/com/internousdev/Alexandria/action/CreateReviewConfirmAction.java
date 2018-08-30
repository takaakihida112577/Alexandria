package com.internousdev.Alexandria.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateReviewConfirmAction extends ActionSupport implements SessionAware{

	Map<String,Object> session;
	private int productId;
	private String reviewTitle;
	private String reviewText;
	private int star;

	//エラーメッセージを格納するリスト
	private List<String> reviewTitleErrorMessageList;
	private List<String> reviewTextErrorMessageList;
	private String starErrorMessageList="";

	public String execute(){

		String result = ERROR;

		session.put("productId", productId);
		session.put("reviewTitle", reviewTitle);
		session.put("reviewText", reviewText);
		session.put("star", star);

		//入力内容のチェック
		InputChecker inputChecker = new InputChecker();
		reviewTitleErrorMessageList = inputChecker.doCheck("レビュータイトル", reviewTitle, 1, 30, true, true, true, true, true, true, true);
		reviewTextErrorMessageList = inputChecker.doCheck("レビュー内容", reviewText, 1, 255, true, true, true, true, true, true, true);
		if(star==0){
			starErrorMessageList = "商品の評価を選択してください";
		}

		//エラーメッセージがない場合はSUCCESS
		if(reviewTitleErrorMessageList.size()==0 && reviewTextErrorMessageList.size()==0 && starErrorMessageList.equals("")){
			result = SUCCESS;
		}else{
			session.put("reviewTitleErrorMessageList", reviewTitleErrorMessageList);
			session.put("reviewTextErrorMessageList", reviewTextErrorMessageList);
			session.put("starErrorMessageList", starErrorMessageList);
			result = ERROR;
		}

		return result;

	}

	public Map<String,Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}

	public int getProductId(){
		return productId;
	}

	public void setProductId(int productId){
		this.productId = productId;
	}

	public String getReviewTitle(){
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle){
		this.reviewTitle = reviewTitle;
	}

	public String getReviewText(){
		return reviewText;
	}

	public void setReviewText(String reviewText){
		this.reviewText = reviewText;
	}

	public int getStar(){
		return star;
	}

	public void setStar(int star){
		this.star = star;
	}
}
