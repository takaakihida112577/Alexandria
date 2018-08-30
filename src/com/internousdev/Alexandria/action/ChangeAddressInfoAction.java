package com.internousdev.Alexandria.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ChangeAddressInfoAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private String id;
	private String lastName;
	private String firstName;
	private String lastNameKana;
	private String firstNameKana;
	private String email;
	private String telNumber;
	private String postal;
	private String address;

	public String execute(){
		//セッション切れ対策
		/*
		if((!session.containsKey("loginId")) || (!session.containsKey("lastName"))){
			return ERROR;
		}
		*/

		//宛先ＩＤに該当する情報の初期化
		session.put("id", id);
		session.put("lastName", lastName);
		session.put("firstName", firstName);
		session.put("lastNameKana", lastNameKana);
		session.put("firstNameKana", firstNameKana);
		session.put("email", email);
		session.put("telNumber", telNumber);
		session.put("postal", postal);
		session.put("address", address);


		//エラーメッセージリストの初期化
		session.put("lastNameErrorMessageList", "");
		session.put("firstNameErrorMessageList", "");
		session.put("lastNameKanaErrorMessageList", "");
		session.put("firstNameKanaErrorMessageList", "");
		session.put("emailErrorMessageList", "");
		session.put("telNumberErrorMessageList", "");
		session.put("postalErrorMessageList", "");
		session.put("addressErrorMessageList", "");

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

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getLastName(){
		return lastName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getLastNameKana(){
		return lastNameKana;
	}

	public void setLastNameKana(String lastNameKana){
		this.lastNameKana = lastNameKana;
	}

	public String getFirstNameKana(){
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana){
		this.firstNameKana = firstNameKana;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getTelNumber(){
		return telNumber;
	}

	public void setTelNumber(String telNumber){
		this.telNumber = telNumber;
	}

	public String getPostal(){
		return postal;
	}

	public void setPostal(String postal){
		this.postal = postal;
	}

	public String getAddress(){
		return address;
	}

	public void setAddress(String address){
		this.address = address;
	}

}
