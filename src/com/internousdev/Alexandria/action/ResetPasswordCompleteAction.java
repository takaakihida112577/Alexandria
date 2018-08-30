package com.internousdev.Alexandria.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.UserInfoDAO;
import com.internousdev.Alexandria.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		//セッション切れ対策
		if(!session.containsKey("loginId") || !session.containsKey("newPassword")) {
			result = ERROR;
		}

		//パスワードを変更
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		int count = userInfoDAO.resetPassword(String.valueOf(session.get("loginId")), String.valueOf(session.get("newPassword")));
		if(count>0) {
			//完了メッセージリストを作成します
			String[] completeWordList;
			CommonUtility commonUtility = new CommonUtility();
			completeWordList = commonUtility.parseCompleteWord("パスワードの変更が完了しました！！");
			session.put("completeWordList", completeWordList);
			result=SUCCESS;
		}else {
			result = ERROR;
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
}
