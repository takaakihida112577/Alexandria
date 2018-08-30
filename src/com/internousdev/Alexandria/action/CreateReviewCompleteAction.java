package com.internousdev.Alexandria.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.ReviewInfoDAO;
import com.internousdev.Alexandria.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class CreateReviewCompleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private int productId;
	private String reviewTitle;
	private String reviewText;
	private int star;

	public String execute(){

		int count = 0;
		String result = ERROR;

		//レビューを投稿します
		ReviewInfoDAO reviewInfoDAO = new ReviewInfoDAO();
		count = reviewInfoDAO.createReviewInfo(productId, String.valueOf(session.get("loginId")), reviewTitle, reviewText, star);
		if(count > 0){
			//完了メッセージリストを作成します
			String[] completeWordList;
			CommonUtility commonUtility = new CommonUtility();
			completeWordList = commonUtility.parseCompleteWord("レビューの投稿が完了しました！！");
			session.put("completeWordList", completeWordList);
			result = SUCCESS;
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
