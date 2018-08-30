package com.internousdev.Alexandria.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.AddressInfoDAO;
import com.internousdev.Alexandria.dao.UserInfoDAO;
import com.internousdev.Alexandria.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserCompleteAction extends ActionSupport implements SessionAware{
	private String lastName;
	private String firstName;
	private String lastNameKana;
	private String firstNameKana;
	private String birthday;
	private String email;
	private String userId;
	private String password;
	private String telNumber;
	private String postal;
	private String address;
	private Map<String,Object> session;

	public String execute() {
		int count = 0;
		String result = ERROR;

		//ユーザー情報を宛先情報をDBに登録します
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		AddressInfoDAO addressInfoDAO = new AddressInfoDAO();
		count = userInfoDAO.createUserInfo(lastName, firstName, lastNameKana, firstNameKana, birthday, email, userId, password);
		count = addressInfoDAO.createAddressInfo(lastName, firstName, lastNameKana, firstNameKana, email, telNumber, postal, address,userId);

		//ログイン状態にする
		userInfoDAO.login(userId, password);
		session.put("loginId", userId);
		session.put("logined", 1);

		//登録件数が0以上で成功か判断する
		if(count>0) {
			//完了メッセージリストを作成します
			String[] completeWordList;
			CommonUtility commonUtility = new CommonUtility();
			completeWordList = commonUtility.parseCompleteWord("ユーザー情報の登録が完了しました！！");
			session.put("completeWordList", completeWordList);
			result = SUCCESS;
		}

		return result;

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

	public String getBirthday(){
		return birthday;
	}

	public void setBirthday(String birthday){
		this.birthday = birthday;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getUserId(){
		return userId;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
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

	public Map<String,Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}
}
