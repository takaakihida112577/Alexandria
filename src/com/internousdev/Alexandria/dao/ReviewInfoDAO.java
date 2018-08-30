package com.internousdev.Alexandria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.Alexandria.dto.ReviewInfoDTO;
import com.internousdev.Alexandria.util.DBConnector;

public class ReviewInfoDAO {

	//商品IDよりレビューを取得する
	public List<ReviewInfoDTO> getReviewInfoDTOList(int productId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ReviewInfoDTO> reviewInfoDTOList = new ArrayList<ReviewInfoDTO>();
		String sql = "select * from review_info where product_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ReviewInfoDTO dto = new ReviewInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setUserId(rs.getString("user_id"));
				dto.setReviewTitle(rs.getString("review_title"));
				dto.setReviewText(rs.getString("review_text"));
				dto.setStar(rs.getInt("star"));
				dto.setReferenceCount(rs.getInt("reference_count"));
				dto.setInsertDate(rs.getDate("insert_date"));
				reviewInfoDTOList.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reviewInfoDTOList;
	}

	//レビューを投稿する
	public int createReviewInfo(int productId,String userId,String reviewTitle,String reviewText,int star){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;
		String sql = "insert into review_info(product_id,user_id,review_title,review_text,star,insert_date) value(?,?,?,?,?,now())";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ps.setString(2, userId);
			ps.setString(3, reviewTitle);
			ps.setString(4, reviewText);
			ps.setInt(5, star);
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
