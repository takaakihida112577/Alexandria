package com.internousdev.Alexandria.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeUserInfoConfirmAction extends ActionSupport implements SessionAware{

	//入力した値
	private String lastName;
	private String firstName;
	private String lastNameKana;
	private String firstNameKana;
	private String birthday;
	private String email;

	//エラーメッセージ
	private List<String> lastNameErrorMessageList = new ArrayList<String>();
	private List<String> firstNameErrorMessageList = new ArrayList<String>();
	private List<String> lastNameKanaErrorMessageList = new ArrayList<String>();
	private List<String> firstNameKanaErrorMessageList = new ArrayList<String>();
	private List<String> emailErrorMessageList = new ArrayList<String>();
	private List<String> birthdayErrorMessageList = new ArrayList<String>();

	private Map<String,Object> session;

	public String execute(){
		String result = ERROR;
		InputChecker inputChecker = new InputChecker();

		session.put("lastName", lastName);
		session.put("firstName", firstName);
		session.put("lastNameKana", lastNameKana);
		session.put("firstNameKana", firstNameKana);
		session.put("birthdat", birthday);
		session.put("email", email);

		//以下から判別したい文字種を選択します inputChecker
		//availableAlphabeticCharacters=半角英字
		//availableKanji=漢字
		//availableHiragana=ひらがな
		//availableHalfWidthDigit=半角数字
		//availableHalfWidthSymbols=半角記号
		//availableKatakana=カタカナ
		//availableFullWidthSymbols=全角記号
		lastNameErrorMessageList = inputChecker.doCheck("姓", lastName, 1, 16, true, true, true, false, false, true, false);
		firstNameErrorMessageList = inputChecker.doCheck("名", firstName, 1, 16, true, true, true, false, false, true, false);
		lastNameKanaErrorMessageList = inputChecker.doCheck("姓カナ", lastNameKana, 1, 16, false, false, false,false, false, true, false);
		firstNameKanaErrorMessageList = inputChecker.doCheck("名カナ", firstNameKana, 1, 16, false, false, false,false, false, true, false);
		emailErrorMessageList = inputChecker.doCheck("メールアドレス", email, 14, 32, true, false, false, true, true, false, false);
		birthdayErrorMessageList = inputChecker.doCheck("生年月日", birthday, 1, 16, false, false, false, true, true, false, false);

		//エラーメッセージがない場合SUCCESS
		//エラーメッセージがある場合、セッションに追加
		if(lastNameErrorMessageList.size()==0
		&& firstNameErrorMessageList.size()==0
		&& lastNameKanaErrorMessageList.size()==0
		&& firstNameKanaErrorMessageList.size()==0
		&& emailErrorMessageList.size()==0
		&& birthdayErrorMessageList.size()==0){
			result = SUCCESS;
		}else {
			session.put("lastNameErrorMessageList", lastNameErrorMessageList);
			session.put("firstNameErrorMessageList", firstNameErrorMessageList);
			session.put("lastNameKanaErrorMessageList", lastNameKanaErrorMessageList);
			session.put("firstNameKanaErrorMessageList", firstNameKanaErrorMessageList);
			session.put("emailErrorMessageList", emailErrorMessageList);
			session.put("birthdayErrorMessageList", birthdayErrorMessageList);
			result = ERROR;
		}
		return result;
	}

	public Map<String,Object> session(){
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
}
