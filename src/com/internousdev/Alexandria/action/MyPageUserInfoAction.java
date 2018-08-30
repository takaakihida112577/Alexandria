package com.internousdev.Alexandria.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.AddressInfoDAO;
import com.internousdev.Alexandria.dao.UserInfoDAO;
import com.internousdev.Alexandria.dto.AddressInfoDTO;
import com.internousdev.Alexandria.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageUserInfoAction extends ActionSupport implements SessionAware{

	Map<String,Object> session;

	public String execute(){
		String result = ERROR;

		//ユーザー情報を取得します
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		UserInfoDTO userInfoDTO = new UserInfoDTO();

		userInfoDTO = userInfoDAO.getUserInfoByMyPage(String.valueOf(session.get("loginId")));
		if(userInfoDTO != null){
			session.put("userId", userInfoDTO.getUserId());
			session.put("lastName", userInfoDTO.getLastName());
			session.put("firstName", userInfoDTO.getFirstName());
			session.put("lastNameKana", userInfoDTO.getlastNameKana());
			session.put("firstNameKana", userInfoDTO.getFirstNameKana());
			session.put("email", userInfoDTO.getEmail());
			session.put("birthday", userInfoDTO.getBirthday());
			session.put("userInfoDTO", userInfoDTO);
			result = SUCCESS;
		}


		//宛先情報を取得します
		AddressInfoDAO addressInfoDAO = new AddressInfoDAO();
		List<AddressInfoDTO> addressInfoDTOList = new ArrayList<AddressInfoDTO>();

		addressInfoDTOList = addressInfoDAO.getAddressInfoDTO(String.valueOf(session.get("loginId")));
		Iterator<AddressInfoDTO> iterator = addressInfoDTOList.iterator();
		if(iterator.hasNext()){
			session.put("addressInfoDTOList", addressInfoDTOList);
		}else{
			addressInfoDTOList = null;
		}

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}
}
