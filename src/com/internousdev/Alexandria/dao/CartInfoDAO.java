package com.internousdev.Alexandria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.Alexandria.dto.CartInfoDTO;
import com.internousdev.Alexandria.util.DBConnector;

public class CartInfoDAO {

	//カートに商品を追加します
	public int CreateCartInfo(String userId,String tempUserId,int productId,int productCount,int price){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;
		String sql = "insert into cart_info(user_id,temp_user_id,product_id,product_count,price,insert_date,update_date) value(?,?,?,?,?,now(),now())";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, tempUserId);
			ps.setInt(3, productId);
			ps.setInt(4, productCount);
			ps.setInt(5, price);
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

	//ユーザーIDよりカート内にある商品情報を取得する
	public List<CartInfoDTO> getCartInfoDTOList(String loginId){
		List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select"
				+" ci.id as id,"
				+" ci.user_id as user_id,"
				+" ci.temp_user_id as temp_user_id,"
				+" ci.product_id as product_id,"
				+" sum(ci.product_count) as product_count,"
				+" ci.price as price,"
				+" pi.product_name as product_name,"
				+" pi.product_image as product_image,"
				+" pi.release_company as release_company,"
				+" pi.release_date as release_date,"
				+" pi.product_short_description as product_short_description,"
				+" pi.product_description as product_description,"
				+" (sum(ci.product_count)*ci.price) as subtotal"
				+" from cart_info as ci"
				+" LEFT JOIN product_info as pi"
				+" ON ci.product_id=pi.product_id"
				+" where ci.user_id = ?"
				+" group by product_id";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CartInfoDTO dto = new CartInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setUserId(rs.getString("user_id"));
				dto.setTempUserId(rs.getString("temp_user_id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductCount(rs.getInt("product_count"));
				dto.setPrice(rs.getInt("price"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductImage(rs.getString("product_image"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setProductShortDescription(rs.getString("product_short_description"));
				dto.setProductDescription(rs.getString("product_description"));
				dto.setSubTotal(rs.getInt("subtotal"));
				cartInfoDTOList.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cartInfoDTOList;
	}

	//カート内の合計金額を算出する
	public int getTotalPrice(String loginId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int totalPrice = 0;
		String sql = "select sum(product_count * price) as total_price from cart_info where user_id=? group by user_id";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				totalPrice += rs.getInt("total_price");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return totalPrice;
	}

	//カートIDより商品を削除します
	public int deleteCartInfo(String id){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;
		String sql = "delete from cart_info where id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
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

	public int linkToLoginId(String tempUserId, String loginId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;
		String sql = "update cart_info set user_id=?, temp_user_id = null where temp_user_id=?";

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, tempUserId);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
