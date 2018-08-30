package com.internousdev.Alexandria.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.UserInfoDAO;
import com.internousdev.Alexandria.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class ChargePointCompleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private int point;

	public String execute(){

		String result = ERROR;
		String[] completeWordList;
		int count = 0;

		//ポイントをDBにアップデートします
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		//String.valueOf(session.get("loginId")) => "sample"
		//200 => session.get("point");
		count = userInfoDAO.pointCharge(point+Integer.parseInt(session.get("point").toString()),String.valueOf(session.get("loginId")));

		if(count > 0){
			session.put("point", point+Integer.parseInt(session.get("point").toString()));

			//完了メッセージリストを作成します
			CommonUtility commonUtility = new CommonUtility();
			completeWordList = commonUtility.parseCompleteWord("ポイントチャージが完了しました！！");
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

	public int getPoint(){
		return point;
	}

	public void setPoint(int point){
		this.point = point;
	}
}
