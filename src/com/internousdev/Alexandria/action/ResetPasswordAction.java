package com.internousdev.Alexandria.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
public class ResetPasswordAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;

	public String execute(){

		//エラーメッセージリストの初期化
		session.remove("loginIdErrorMessageList");
		session.remove("passwordErrorMessageList");

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
