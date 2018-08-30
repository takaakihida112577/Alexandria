package com.internousdev.Alexandria.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.AddressInfoDAO;
import com.internousdev.Alexandria.dao.CartInfoDAO;
import com.internousdev.Alexandria.dao.UserInfoDAO;
import com.internousdev.Alexandria.dto.AddressInfoDTO;
import com.internousdev.Alexandria.dto.UserInfoDTO;
import com.internousdev.Alexandria.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginId;
	private String password;
	private boolean savedLoginId;

	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();

	Map<String,Object> session;

	public String execute() {
		String result = ERROR;

		//セッション切れ対策

		//ログインIDの保存にチェックがあるか
		if(savedLoginId == true) {
			session.put("savedLoginId", true);
			session.put("loginId", loginId);
		}else {
			session.put("savedLoginId", false);
			session.remove("loginId",loginId);
		}

		//入力内容のチェック
		InputChecker inputChecker = new InputChecker();
		loginIdErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1, 16, true, false, false, true, false, false, false);
		passwordErrorMessageList = inputChecker.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false, false);

		if(loginIdErrorMessageList.size()!=0 && passwordErrorMessageList.size()!=0) {
			session.put("loginIdErrorMessageList", loginIdErrorMessageList);
			session.put("passwordErrorMessageList", passwordErrorMessageList);
			session.put("logined", 0);
		}

		//パスワードの確認
		//ユーザーIDとパスワードのチェック
		//true=>DBのlogin_Flgをログイン済みに変える
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		if(userInfoDAO.existsUserInfo(loginId, password)) {
			if(userInfoDAO.login(loginId, password)>0) {

				//ユーザー情報を取得する
				UserInfoDTO userInfoDTO = userInfoDAO.getUserInfo(loginId, password);
				session.put("loginId", userInfoDTO.getUserId());

				int count = 0;
				CartInfoDAO cartInfoDAO = new CartInfoDAO();

				count = cartInfoDAO.linkToLoginId(String.valueOf(session.get("tempUserId")), loginId);
				if(count > 0){
					AddressInfoDAO AddressInfoDAO = new AddressInfoDAO();
						List<AddressInfoDTO> addressInfoDTOList =new ArrayList<AddressInfoDTO>();
						addressInfoDTOList = AddressInfoDAO.getAddressInfoDTO(loginId);
						Iterator<AddressInfoDTO> iterator = addressInfoDTOList.iterator();
						if(!(iterator.hasNext())){
							addressInfoDTOList = null;
						}
						session.put("addressInfoDTOList", addressInfoDTOList);
					result = "settlement";
				}else{
					result = SUCCESS;
				}

				session.put("logined", 1);
				session.put("faceShots", userInfoDTO.getFaceShots());

				//ポイントの取得
				session.put("point", userInfoDTO.getPoint());
			}
		}
		return result;
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


	public boolean getSavedLoginId() {
		return savedLoginId;
	}

	public void setSavedLoginId(boolean savedLoginId) {
		this.savedLoginId = savedLoginId;
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
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
