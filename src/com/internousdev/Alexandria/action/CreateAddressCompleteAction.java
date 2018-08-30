package com.internousdev.Alexandria.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.AddressInfoDAO;
import com.internousdev.Alexandria.dto.AddressInfoDTO;
import com.internousdev.Alexandria.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class CreateAddressCompleteAction extends ActionSupport implements SessionAware{
	private String lastName;
	private String firstName;
	private String lastNameKana;
	private String firstNameKana;
	private String email;
	private String telNumber;
	private String postal;
	private String address;
	private Map<String,Object> session;

	public String execute(){
		int count = 0;
		String result=ERROR;

		//宛先情報を新規登録します
		AddressInfoDAO addressInfoDAO = new AddressInfoDAO();
		//String.valueOf(session.get("loginId"))
		count = addressInfoDAO.createAddressInfo(lastName, firstName, lastNameKana, firstNameKana, email, telNumber, postal, address, "sample");
		if(count>0){
			//完了メッセージリストを作成します
			String[] completeWordList;
			CommonUtility commonUtility = new CommonUtility();
			completeWordList = commonUtility.parseCompleteWord("宛先情報の登録が完了しました！！");
			session.put("completeWordList", completeWordList);
			result = SUCCESS;
		}

		//新規登録したので宛先情報を新たに取得します
		List<AddressInfoDTO> addressInfoDTOList = new ArrayList<AddressInfoDTO>();
		addressInfoDTOList = addressInfoDAO.getAddressInfoDTO("sample");
		//宛先情報があるのか調べます
		Iterator<AddressInfoDTO> iterator = addressInfoDTOList.iterator();
		if(!(iterator.hasNext())){
			addressInfoDTOList = null;
		}
		session.put("addressInfoDTOList", addressInfoDTOList);
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

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
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

	public Map<String,Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}
}
