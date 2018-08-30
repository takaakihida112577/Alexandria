package com.internousdev.Alexandria.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ChangeUserInfoAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;

	public String execute(){

		//セッション切れ対策
		/*
		if((!session.containsKey("loginId")) || (!session.containsKey("lastName"))){
			return ERROR;
		}
		*/

		//エラーメッセージリストの初期化
		session.put("lastNameErrorMessageList", "");
		session.put("firstNameErrorMessageList", "");
		session.put("lastNameKanaErrorMessageList", "");
		session.put("firstNameKanaErrorMessageList", "");
		session.put("emailErrorMessageList", "");
		session.put("birthdayErrorMessageList", "");

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
