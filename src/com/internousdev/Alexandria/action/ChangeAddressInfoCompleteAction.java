package com.internousdev.Alexandria.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.AddressInfoDAO;
import com.internousdev.Alexandria.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeAddressInfoCompleteAction  extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private String lastName;
	private String firstName;
	private String lastNameKana;
	private String firstNameKana;
	private String email;
	private String telNumber;
	private String postal;
	private String address;


	public String execute(){
		int count = 0;
		String result = ERROR;

		//ＤＢのユーザー情報を変更します
		AddressInfoDAO addressInfoDAO = new AddressInfoDAO();
		count = addressInfoDAO.updateAddressInfo(lastName, firstName, lastNameKana, firstNameKana, email, telNumber, postal, address, String.valueOf(session.get("id")));

		if(count > 0){
			System.out.println("changeAddressInfoComplete");
			session.remove("id");

			//完了メッセージリストを作成します
			String[] completeWordList;
			CommonUtility commonUtility = new CommonUtility();
			completeWordList = commonUtility.parseCompleteWord("宛先情報の変更が完了しました！！");
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
