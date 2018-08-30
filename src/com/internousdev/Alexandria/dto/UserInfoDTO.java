package com.internousdev.Alexandria.dto;

import java.sql.Date;

public class UserInfoDTO {

	private int id;
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
	private String faceShots;
	private int loginFlg;
	private int point;
	private Date insertDate;
	private Date updateDate;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
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

	public String getlastNameKana(){
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

	public void setTelNuber(String telNumber){
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

	public String getFaceShots(){
		return faceShots;
	}

	public void setFaceShots(String faceShots){
		this.faceShots = faceShots;
	}

	public int getLoginFlg() {
		return loginFlg;
	}

	public void setLoginFlg(int loginFlg) {
		this.loginFlg = loginFlg;
	}

	public Date getInsertDate(){
		return insertDate;
	}

	public void setInsertDate(Date insertDate){
		this.insertDate = insertDate;
	}

	public Date getUpdateDate(){
		return updateDate;
	}

	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}

	public int getPoint(){
		return point;
	}

	public void setPoint(int point){
		this.point = point;
	}
}
