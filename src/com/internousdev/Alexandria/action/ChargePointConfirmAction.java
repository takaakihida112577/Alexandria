package com.internousdev.Alexandria.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.UserInfoDAO;
import com.internousdev.Alexandria.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ChargePointConfirmAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private String loginId;
	private String password;
	private String point;
	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();
	private String loginErrorMessageList = "";
	private List<String> pointErrorMessageList = new ArrayList<String>();

	public String execute(){

		String result = ERROR;
		System.out.println("pointerror1");

		//入力内容の確認をします
		InputChecker inputChecker = new InputChecker();
		loginIdErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1, 16, true, false, false, true, false, false, false);
		passwordErrorMessageList = inputChecker.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false, false);
		pointErrorMessageList = inputChecker.doCheck("ポイント", point, 1, 16, false, false, false, true, false, false, false);

		if(loginIdErrorMessageList.size()==0 && passwordErrorMessageList.size()==0 && pointErrorMessageList.size()==0) {
			//パスワードとユーザーIDが正しいか2段階で確認をします
			UserInfoDAO userInfoDAO = new UserInfoDAO();

			//String.valueOf(session.get("loginId")).equals(loginId)
			if(loginId.equals("sample")){
				if(userInfoDAO.existsUserInfo(loginId, password)){

							result = SUCCESS;
				}
			}else{
				loginErrorMessageList="現在ログインしているユーザーと異なります。またはログインIDとパスワードが異なります";
				session.put("loginErrorMessageList",loginErrorMessageList);
			}

		}else{
			session.put("loginIdErrorMessageList", loginIdErrorMessageList);
			session.put("passwordErrorMessageList", passwordErrorMessageList);
			session.put("pointErrorMessageList", pointErrorMessageList);
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

	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getLoginIdErrorMessageList() {
		return loginIdErrorMessageList;
	}
	public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList) {
		this.loginIdErrorMessageList = loginIdErrorMessageList;
	}
	public List<String> getPasswordErrorMessageList() {
		return passwordErrorMessageList;
	}
	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
		this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public String getLoginErrorMessageList(){
		return loginErrorMessageList;
	}

	public void setLoginErrorMessageList(String loginErrorMessageList){
		this.loginErrorMessageList = loginErrorMessageList;
	}

	public List<String> getPointErrorMessageList(){
		return pointErrorMessageList;
	}

	public void setPointErrorMessageList(List<String> pointErrorMessageList){
		this.pointErrorMessageList = pointErrorMessageList;
	}

	public String getPoint(){
		return point;
	}

	public void setPoint(String point){
		this.point = point;
	}

}
