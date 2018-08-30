package com.internousdev.Alexandria.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.CartInfoDAO;
import com.internousdev.Alexandria.dao.MasterCategoryDAO;
import com.internousdev.Alexandria.dto.CartInfoDTO;
import com.internousdev.Alexandria.dto.MasterCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();

	public String execute() {

		String userId = null;

		session.remove("checkListErrorMessageList");

		//セッション切れ対策
		if(!session.containsKey("masterCategoryDTOList")) {
			List<MasterCategoryDTO> masterCategoryDTOList  = new ArrayList<MasterCategoryDTO>();
			MasterCategoryDAO masterCategoryDAO = new MasterCategoryDAO();
			masterCategoryDTOList = masterCategoryDAO.getMasterCategory();
			session.put("masterCategoryDTOList", masterCategoryDTOList);
		}

		//ログインしているか判断してuserIdを設定
		if(session.containsKey("loginId")) {
			userId = String.valueOf(session.get("loginId"));
		}else if (session.containsKey("tempUserId")) {
			userId = String.valueOf(session.get("tempUserId"));
		}

		//カート情報を取得する
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();
		cartInfoDTOList = cartInfoDAO.getCartInfoDTOList(userId);
		Iterator<CartInfoDTO> iterator = cartInfoDTOList.iterator();
		if(!(iterator.hasNext())) {
			cartInfoDTOList = null;
		}
		session.put("cartInfoDTOList", cartInfoDTOList);

		//カート内のトータル金額を取得する
		int totalPrice = cartInfoDAO.getTotalPrice(userId);
		session.put("totalPrice", totalPrice);

		return SUCCESS;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}

	public List<CartInfoDTO> getCartInfoDTOList(){
		return cartInfoDTOList;
	}

	public void setCartInfoDTOList(List<CartInfoDTO> cartInfoDTOList) {
		this.cartInfoDTOList = cartInfoDTOList;
	}
}
