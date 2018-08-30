package com.internousdev.Alexandria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.Alexandria.dto.UserInfoDTO;
import com.internousdev.Alexandria.util.DBConnector;
import com.internousdev.Alexandria.util.DateUtil;

public class UserInfoDAO {

	//新規のユーザーを登録するメソッドです
	public int createUserInfo(String lastName,String firstName,String lastNameKana,String firstNameKana,String birthday,String email,String userId,String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
		int count = 0;
		String sql = "insert into user_info(user_id,password,last_name,first_Name,last_name_kana,first_name_kana,email,birthday,insert_date) value(?,?,?,?,?,?,?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			ps.setString(3, lastName);
			ps.setString(4, firstName);
			ps.setString(5, lastNameKana);
			ps.setString(6, firstNameKana);
			ps.setString(7, email);
			ps.setString(8, birthday);
			ps.setString(9, dateUtil.getDate());

			//SQL文を実行し、登録した件数をcountに代入。失敗の場合は0
			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return count;
	}

	//ユーザー情報をログインIDを元に取得するメソッドです
	public UserInfoDTO getUserInfoByMyPage(String loginId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		String sql = "select * from user_info where user_id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				userInfoDTO.setId(rs.getInt("id"));
				userInfoDTO.setUserId(rs.getString("user_id"));
				userInfoDTO.setPassword(rs.getString("password"));
				userInfoDTO.setLastName(rs.getString("last_name"));
				userInfoDTO.setFirstName(rs.getString("first_name"));
				userInfoDTO.setLastNameKana(rs.getString("last_name_kana"));
				userInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				userInfoDTO.setBirthday(rs.getString("birthday"));
				userInfoDTO.setEmail(rs.getString("email"));
				userInfoDTO.setLoginFlg(rs.getInt("login_flg"));
				userInfoDTO.setInsertDate(rs.getDate("insert_date"));
				userInfoDTO.setUpdateDate(rs.getDate("update_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoDTO;
	}

	//ユーザー情報をログインIDとパスワードを元に取得するメソッドです
	public UserInfoDTO getUserInfo(String loginId, String password) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		String sql = "select * from user_info where user_id=? and password=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				userInfoDTO.setId(rs.getInt("id"));
				userInfoDTO.setUserId(rs.getString("user_id"));
				userInfoDTO.setPassword(rs.getString("password"));
				userInfoDTO.setLastName(rs.getString("last_name"));
				userInfoDTO.setFirstName(rs.getString("first_name"));
				userInfoDTO.setLastNameKana(rs.getString("last_name_kana"));
				userInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				userInfoDTO.setEmail(rs.getString("email"));
				userInfoDTO.setLoginFlg(rs.getInt("login_flg"));
				userInfoDTO.setInsertDate(rs.getDate("insert_date"));
				userInfoDTO.setUpdateDate(rs.getDate("update_date"));
				userInfoDTO.setPoint(rs.getInt("point"));
				userInfoDTO.setFaceShots(rs.getString("head_shots"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoDTO;
	}

	//ログイン時にユーザーIDとパスワードが存在するか判別するメソッドです
	public boolean existsUserInfo(String loginId,String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		boolean result = false;
		String sql = "select count(*) as count from user_info where user_id=? and password=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt("count")>0) {
					result = true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//DBの情報をログイン済みに変える
	public int login(String loginId,String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;
		String sql = "update user_info set login_Flg=1 where user_id=? and password=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int logout(String loginId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result=0;
		String sql = "update user_info set login_Flg=0 where user_id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//パスワードの表示を例)sample =>sa********と変換するメソッドです。セキュリティ対策
	public String concealPassword(String password) {
		int beginIndex = 0;
		int endIndex = 1;

		if(password.length() > 1) {
			endIndex = 2;
		}

		StringBuilder stringBuilder = new StringBuilder("****************");
		String concealPassword = stringBuilder.replace(beginIndex, endIndex, password.substring(beginIndex, endIndex)).toString();

		return concealPassword;
	}

	//パスワードを変更するメソッドです。
	public int resetPassword(String loginId,String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "update user_info set password=? where user_id=?";
		int result = 0;

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, loginId);
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//ユーザー情報を変更するメソッドです
	public int updateUserInfo(String lastName,String firstName,String lastNameKana,String firstNameKana,String birthday,String email,String userId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;
		String sql = "update user_info set last_name=?,first_name=?,last_name_kana=?,first_name_kana=?,birthday=?,email=? where user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, lastName);
			ps.setString(2, firstName);
			ps.setString(3, lastNameKana);
			ps.setString(4, firstNameKana);
			ps.setString(5, birthday);
			ps.setString(6, email);
			ps.setString(7, userId);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	//決済分だけpointを減らします。
	public int settlementPoint(int point,int settlementPoint,String userId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;
		int updatePoint = point - settlementPoint;
		String sql = "update user_info set point=? where user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, updatePoint);
			ps.setString(2, userId);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	//ポイントチャージするメソッドです
	public int pointCharge(int point,String userId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;
		String sql ="update user_info set point=? where user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, point);
			ps.setString(2, userId);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	//顔写真を登録します
	public int updateFaceShots(String userImageFileName,String loginId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;
		String sql ="update user_info set head_shots=? where user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userImageFileName);
			ps.setString(2, loginId);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
}
