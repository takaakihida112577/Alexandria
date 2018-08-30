package com.internousdev.Alexandria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.Alexandria.dto.AddressInfoDTO;
import com.internousdev.Alexandria.util.DBConnector;
import com.internousdev.Alexandria.util.DateUtil;

public class AddressInfoDAO {

	//新規の宛先情報を登録するメソッドです
	public int createAddressInfo(String lastName,String firstName,String lastNameKana,String firstNameKana,String email,String telNumber,String postal,String address,String userId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
		int count = 0;
		String sql = "insert into address_info(user_id,last_name,first_name,last_name_kana,first_name_kana,email,tel_number,postal,address,insert_date) value(?,?,?,?,?,?,?,?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, lastName);
			ps.setString(3, firstName);
			ps.setString(4, lastNameKana);
			ps.setString(5, firstNameKana);
			ps.setString(6, email);
			ps.setString(7, telNumber);
			ps.setString(8, postal);
			ps.setString(9, address);
			ps.setString(10, dateUtil.getDate());

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

	//宛先情報を取得します
	public List<AddressInfoDTO> getAddressInfoDTO(String loginId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<AddressInfoDTO> addressInfoDTOList = new ArrayList<AddressInfoDTO>();
		String sql = "select * from address_info where user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				AddressInfoDTO dto = new AddressInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setUserId(rs.getString("user_id"));
				dto.setLastName(rs.getString("last_name"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastNameKana(rs.getString("last_name_kana"));
				dto.setFirstNameKana(rs.getString("first_name_kana"));
				dto.setEmail(rs.getString("email"));
				dto.setTelNuber(rs.getString("tel_number"));
				dto.setPostal(rs.getString("postal"));
				dto.setAddress(rs.getString("address"));
				addressInfoDTOList.add(dto);
				System.out.println("lastnamekana"+rs.getString("last_name_kana"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return addressInfoDTOList;
	}

	//宛先情報を変更します
	public int updateAddressInfo(String lastName,String firstName,String lastNameKana,String firstNameKana,String email,String telNumber,String postal,String address,String id){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;
		String sql = "update address_info set last_name=?,first_name=?,last_name_kana=?,first_name_kana=?,email=?,tel_number=?,postal=?,address=? where id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, lastName);
			ps.setString(2, firstName);
			ps.setString(3, lastNameKana);
			ps.setString(4, firstNameKana);
			ps.setString(5, email);
			ps.setString(6, telNumber);
			ps.setString(7, postal);
			ps.setString(8, address);
			ps.setString(9, id);
			System.out.println("id"+id);
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
