package com.internousdev.Alexandria.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserConfirmAction extends ActionSupport implements SessionAware{

	//createUser.jspで入力した値
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

	//エラーメッセージを格納するリスト
	private List<String> lastNameErrorMessageList = new ArrayList<String>();
	private List<String> firstNameErrorMessageList = new ArrayList<String>();
	private List<String> lastNameKanaErrorMessageList = new ArrayList<String>();
	private List<String> firstNameKanaErrorMessageList = new ArrayList<String>();
	private List<String> emailErrorMessageList = new ArrayList<String>();
	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();
	private List<String> birthdayErrorMessageList = new ArrayList<String>();
	private List<String> telNumberErrorMessageList = new ArrayList<String>();
	private List<String> postalErrorMessageList = new ArrayList<String>();
	private List<String> addressErrorMessageList = new ArrayList<String>();

	private Map<String,Object> session;
	public String execute() {
		String result = ERROR;
		InputChecker inputChecker = new InputChecker();

		session.put("lastName", lastName);
		session.put("firstName", firstName);
		session.put("lastNameKana", lastNameKana);
		session.put("firstNameKana", firstNameKana);
		session.put("birthdat", birthday);
		session.put("email", email);
		session.put("userId", userId);
		session.put("password", password);
		session.put("telNumber", telNumber);
		session.put("postal", postal);
		session.put("address", address);

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
		loginIdErrorMessageList = inputChecker.doCheck("ユーザーID", userId, 1, 16, true, false, false, true, false, false, false);
		passwordErrorMessageList = inputChecker.doCheck("パスワード", userId, 1, 16, true, false, false, true, false, false, false);
		birthdayErrorMessageList = inputChecker.doCheck("生年月日", birthday, 1, 16, false, false, false, true, true, false, false);
		telNumberErrorMessageList =inputChecker.doTelNumberCheck("電話番号", telNumber, 13);
		postalErrorMessageList = inputChecker.doPostalCheck("郵便番号", postal, 8);
		addressErrorMessageList = inputChecker.doCheck("住所", address, 15, 50, true, true, true, true, true, true, false);

		//エラーメッセージがない場合SUCCESS
		//エラーメッセージがある場合、セッションに追加
		if(lastNameErrorMessageList.size()==0
		&& firstNameErrorMessageList.size()==0
		&& lastNameKanaErrorMessageList.size()==0
		&& firstNameKanaErrorMessageList.size()==0
		&& emailErrorMessageList.size()==0
		&& loginIdErrorMessageList.size()==0
		&& passwordErrorMessageList.size()==0
		&& birthdayErrorMessageList.size()==0
		&& telNumberErrorMessageList.size()==0
		&& postalErrorMessageList.size()==0
		&& addressErrorMessageList.size()==0) {
			result = SUCCESS;
		}else {
			session.put("lastNameErrorMessageList", lastNameErrorMessageList);
			session.put("firstNameErrorMessageList", firstNameErrorMessageList);
			session.put("lastNameKanaErrorMessageList", lastNameKanaErrorMessageList);
			session.put("firstNameKanaErrorMessageList", firstNameKanaErrorMessageList);
			session.put("emailErrorMessageList", emailErrorMessageList);
			session.put("loginIdErrorMessageList", loginIdErrorMessageList);
			session.put("passwordErrorMessageList", passwordErrorMessageList);
			session.put("birthdayErrorMessageList", birthdayErrorMessageList);
			session.put("telNumberErrorMessageList", telNumberErrorMessageList);
			session.put("postalErrorMessageList", postalErrorMessageList);
			session.put("addressErrorMessageList", addressErrorMessageList);
			result = ERROR;
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

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}
}
