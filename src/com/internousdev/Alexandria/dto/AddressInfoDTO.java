package com.internousdev.Alexandria.dto;

public class AddressInfoDTO {
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
	private String insertDate;
	private String updateDate;

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

	public String getInsertDate(){
		return insertDate;
	}

	public void setInsertDate(String insertDate){
		this.insertDate = insertDate;
	}

	public String getUpdateDate(){
		return updateDate;
	}

	public void setUpdateDate(String updateDate){
		this.updateDate = updateDate;
	}
}
