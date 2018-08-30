package com.internousdev.Alexandria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.Alexandria.dto.HistoryInfoDTO;
import com.internousdev.Alexandria.util.DBConnector;
public class HistoryInfoDAO {

	//購入履歴を作成します
	public int createHistoryInfo(String userId,int productId,int productCount,int price,int addressId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;
		String sql = "insert into history_info(user_id,product_id,product_count,price,address_id,insert_date,update_date) value(?,?,?,?,?,now(),now())";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, productId);
			ps.setInt(3, productCount);
			ps.setInt(4, price);
			ps.setInt(5, addressId);
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

	//購入履歴をユーザーID元に取得します
	public List<HistoryInfoDTO> getHistoryInfo(String userId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<HistoryInfoDTO> historyInfoDTOList = new ArrayList<HistoryInfoDTO>();
		String sql = "select pi.product_name,pi.product_image,pi.release_company,pi.release_date,hi.id,hi.product_id,hi.product_count,hi.price,hi.insert_date from product_info as pi inner join history_info as hi on pi.product_id=hi.product_id where hi.user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				HistoryInfoDTO dto = new HistoryInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductImage(rs.getString("product_image"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setProductCount(rs.getInt("product_count"));
				dto.setPrice(rs.getInt("price"));
				dto.setInsertDate(rs.getDate("insert_date"));
				historyInfoDTOList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return historyInfoDTOList;
	}

	//購入履歴を削除します
	public int deleteHistoryInfo(String id){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;
		String sql = "delete from history_info where id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
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
