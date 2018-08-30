package com.internousdev.Alexandria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.Alexandria.dto.ProductInfoDTO;
import com.internousdev.Alexandria.util.DBConnector;

public class ProductInfoDAO {

	//引数に指定されたカテゴリIDに分類される商品情報を取得します
	public List<ProductInfoDTO> getProductInfoListOfCategory(int categoryId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		String sql = "select * from product_info where category_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductInfoDTO dto = new ProductInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductShortDescription(rs.getString("product_short_description"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setProductImage(rs.getString("product_image"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setPrice(rs.getInt("price"));
				dto.setRank(rs.getInt("rank"));
				productInfoDTOList.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return productInfoDTOList;
	}

	//商品IDより商品情報を取得します
	public ProductInfoDTO getProductInfoDetails(int productId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();
		String sql = "select * from product_info where product_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				productInfoDTO.setId(rs.getInt("id"));
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductShortDescription(rs.getString("product_short_description"));
				productInfoDTO.setProductDescription(rs.getString("product_description"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setProductImage(rs.getString("product_image"));
				productInfoDTO.setReleaseDate(rs.getDate("release_date"));
				productInfoDTO.setReleaseCompany(rs.getString("release_company"));
				productInfoDTO.setRank(rs.getInt("rank"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return productInfoDTO;
	}

	//商品詳細と同じカテゴリの商品を3つ取得します
	public List<ProductInfoDTO> getProductInfoListRelevance(int categoryId,int productId,int startRecordNo,int endRecordNo){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		String sql = "select * from product_info where category_id=? and product_id not in(?) order by rand() limit ?,?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ps.setInt(2, productId);
			ps.setInt(3, startRecordNo);
			ps.setInt(4, endRecordNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductInfoDTO dto = new ProductInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductShortDescription(rs.getString("product_short_description"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setReleaseDate(rs.getDate("release_date"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setProductImage(rs.getString("product_image"));
				dto.setPrice(rs.getInt("price"));
				productInfoDTOList.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return productInfoDTOList;
	}

	//検索ワードとカテゴリーIDにより商品情報を取得します
	public List<ProductInfoDTO> getProductInfoListSerch(String[] keywordsList,String categoryId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		boolean init = true;
		String sql = "select * from product_info where";

		for(String keyword : keywordsList) {
			if(init) {
				sql += " category_id=" + categoryId + " and (product_name like '%" + keyword + "%')";
				init = false;
			}else {
				sql += " and (product_name like '%" + keyword + "%')";
			}
		}

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductInfoDTO dto = new ProductInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductShortDescription(rs.getString("product_short_description"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setProductImage(rs.getString("product_image"));
				dto.setRank(rs.getInt("rank"));
				productInfoDTOList.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return productInfoDTOList;
	}

	//検索ワードとカテゴリーIDにより商品情報を取得します
	public List<ProductInfoDTO> getProductInfoListSerchAll(String[] keywordsList){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		boolean init = true;
		String sql = "select * from product_info where";

		for(String keyword : keywordsList) {
			if(init) {
				sql += " (product_name like '%" + keyword + "%')";
				init = false;
			}else {
				sql += " and (product_name like '%" + keyword + "%')";
			}
		}

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductInfoDTO dto = new ProductInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductShortDescription(rs.getString("product_short_description"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setProductImage(rs.getString("product_image"));
				dto.setRank(rs.getInt("rank"));
				productInfoDTOList.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return productInfoDTOList;
	}

	//商品のランキングを取得します
	public List<ProductInfoDTO> getProductInfoByRank(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		String sql = "SELECT * FROM product_info ORDER BY rank ASC limit 0,3";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductInfoDTO dto = new ProductInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductShortDescription(rs.getString("product_short_description"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setProductImage(rs.getString("product_image"));
				productInfoDTOList.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return productInfoDTOList;
	}

	//商品の合計rank数を取得
	public int[] getTotalRank(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select avg(rank) as avgRank,max(rank) as maxRank,min(rank) as minRank from product_info";
		int[] result = new int[3];

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("avgRank"+rs.getInt("avgRank"));
				System.out.println("maxRank"+rs.getInt("maxRank"));
				System.out.println("minRank"+rs.getInt("minRank"));
				result[0] = (int)(rs.getInt("avgRank"));
				result[1] = rs.getInt("maxRank");
				result[2] = rs.getInt("minRank");
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

	//商品のランクを1アップ
	public int updateRank(int productId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "update product_info set rank=rank+1 where product_id=?";
		int result = 0;

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
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
}
