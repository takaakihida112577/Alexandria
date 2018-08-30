package com.internousdev.Alexandria.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class HeadShotsCompleteAction extends ActionSupport implements SessionAware{

	Map<String,Object> session;
	private String userImageFileName;

	public String execute(){
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		System.out.println("userImageFileName"+userImageFileName);
		userInfoDAO.updateFaceShots(userImageFileName, String.valueOf(session.get("loginId")));
		session.put("faceShots", userImageFileName);
		return SUCCESS;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object>session){
		this.session = session;
	}

	public String getUserImageFileName(){
		return userImageFileName;
	}
	public void setUserImageFileName(String userImageFileName){
		this.userImageFileName = userImageFileName;
	}
}
