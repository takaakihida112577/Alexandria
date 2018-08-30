package com.internousdev.Alexandria.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.MasterCategoryDAO;
import com.internousdev.Alexandria.dto.MasterCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoLoginAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;

	public String execute(){

		//セッション切れ対策
		if(!session.containsKey("masterCategoryDTOList")) {
			List<MasterCategoryDTO> masterCategoryDTOList  = new ArrayList<MasterCategoryDTO>();
			MasterCategoryDAO masterCategoryDAO = new MasterCategoryDAO();
			masterCategoryDTOList = masterCategoryDAO.getMasterCategory();
			session.put("masterCategoryDTOList", masterCategoryDTOList);
		}

		//エラーメッセージリストの初期化
		session.put("loginIdErrorMessageList", "");
		session.put("passwordErrorMessageList", "");
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


}
