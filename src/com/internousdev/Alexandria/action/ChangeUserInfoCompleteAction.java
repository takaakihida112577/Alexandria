package com.internousdev.Alexandria.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.UserInfoDAO;
import com.internousdev.Alexandria.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeUserInfoCompleteAction extends ActionSupport implements SessionAware{
	private String lastName;
	private String firstName;
	private String lastNameKana;
	private String firstNameKana;
	private String birthday;
	private String email;
	private Map<String,Object> session;

	public String execute(){
		int count = 0;
		String result = ERROR;

		//ＤＢのユーザー情報を変更します
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		//String.valueOf(session.get("loginId")) => "sample"
		count = userInfoDAO.updateUserInfo(lastName, firstName, lastNameKana, firstNameKana, birthday, email, "sample");
		if(count >0){
			//完了メッセージリストを作成します
			String[] completeWordList;
			CommonUtility commonUtility = new CommonUtility();
			completeWordList = commonUtility.parseCompleteWord("ユーザー情報の変更が完了しました！！");
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

	public Map<String,Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}
}
