package com.internousdev.Alexandria.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.HistoryInfoDAO;
import com.internousdev.Alexandria.dto.HistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteHistoryInfoAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private Collection<String> checkList;

	public String execute(){

		int count = 0;

		System.out.println(checkList);
		//チェックボックスが選択されているかチェック
		List<String> checkListErrorMessageList = new ArrayList<String>();
		if(checkList==null){
			checkListErrorMessageList.add("チェックされていません");
			session.put("checkListErrorMessageList", checkListErrorMessageList);
			return ERROR;
		}

		//購入履歴IDより購入履歴を削除します
		HistoryInfoDAO historyInfoDAO = new HistoryInfoDAO();
		for(String id : checkList){
			count += historyInfoDAO.deleteHistoryInfo(id);
		}

		if(count <= 0){
			checkListErrorMessageList.add("チェックされていません");
			session.put("checkListErrorMessageList", checkListErrorMessageList);
			return ERROR;
		}else{

			//購入履歴情報を取得します
			List<HistoryInfoDTO> historyInfoDTOList = new ArrayList<HistoryInfoDTO>();
			//String.valueOf(session.get("loginId")) => "sample"
			historyInfoDTOList = historyInfoDAO.getHistoryInfo("sample");

			//購入履歴があるか判断します
			Iterator<HistoryInfoDTO> iterator = historyInfoDTOList.iterator();
			if(!iterator.hasNext()){
				historyInfoDTOList = null;
			}
			session.put("historyInfoDTOList", historyInfoDTOList);
		}

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}

	public Collection<String> getCheckList(){
		return checkList;
	}

	public void setCheckList(Collection<String> checkList){
		this.checkList = checkList;
	}
}
