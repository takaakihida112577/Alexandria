package com.internousdev.Alexandria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.Alexandria.dto.MasterCategoryDTO;
import com.internousdev.Alexandria.util.DBConnector;

public class MasterCategoryDAO {

	//全てのカテゴリを取得します
	public List<MasterCategoryDTO> getMasterCategory(){
		List<MasterCategoryDTO> masterCategoryDTOList = new ArrayList<MasterCategoryDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from master_category";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MasterCategoryDTO dto = new MasterCategoryDTO();
				dto.setId(rs.getInt("id"));
				dto.setCategoryId(rs.getInt("category_id"));
				dto.setCategoryName(rs.getString("category_name"));
				dto.setCategoryDescription(rs.getString("category_description"));
				masterCategoryDTOList.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return masterCategoryDTOList;
	}
}
