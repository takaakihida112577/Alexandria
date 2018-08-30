package com.internousdev.Alexandria.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.HistoryInfoDAO;
import com.internousdev.Alexandria.dto.HistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageHistoryInfoAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;

	public String execute(){

		//購入履歴情報を取得します
		List<HistoryInfoDTO> historyInfoDTOList = new ArrayList<HistoryInfoDTO>();
		HistoryInfoDAO historyInfoDAO = new HistoryInfoDAO();

		historyInfoDTOList = historyInfoDAO.getHistoryInfo(String.valueOf(session.get("loginId")));

		//購入履歴があるか判断します
		Iterator<HistoryInfoDTO> iterator = historyInfoDTOList.iterator();
		if(!iterator.hasNext()){
			historyInfoDTOList = null;
		}
		session.put("historyInfoDTOList", historyInfoDTOList);

		return SUCCESS;
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
