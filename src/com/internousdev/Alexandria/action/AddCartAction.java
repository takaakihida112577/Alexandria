package com.internousdev.Alexandria.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.CartInfoDAO;
import com.internousdev.Alexandria.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class AddCartAction extends ActionSupport implements SessionAware{

	private int productId;
	private int price;
	private int productCount;
	private Map<String,Object> session;

	public String execute(){
		String result = ERROR;
		String userId = null;
		String tempUserId = null;
		int count = 0;

		//ログインIDも仮ログインIDもない場合に仮ログインIDを発行します
		if(!(session.containsKey("loginId")) && !(session.containsKey("tempUserId"))){
			CommonUtility commonUtility = new CommonUtility();
			session.put("tempUserId", commonUtility.getRandomTempUserId());
		}

		//ログインIDがある場合の処理です
		if(session.containsKey("loginId")){
			userId = String.valueOf(session.get("loginId"));
		}

		//ログインIDがなく仮ログインIDを発行してある場合の処理です
		if(!(session.containsKey("loginId")) && session.containsKey("tempUserId")){
			userId = String.valueOf(session.get("tempUserId"));
			tempUserId = String.valueOf(session.get("tempUserId"));
		}


		//DBにカート情報を追加します
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		count = cartInfoDAO.CreateCartInfo(userId, tempUserId, productId, productCount, price);
		if(count > 0){
			result = SUCCESS;
		}

		session.remove("checkListErrorMessageList");

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

	public int getPrice(){
		return price;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getProductCount(){
		return productCount;
	}

	public void setProductCount(int productCount){
		this.productCount = productCount;
	}
}
