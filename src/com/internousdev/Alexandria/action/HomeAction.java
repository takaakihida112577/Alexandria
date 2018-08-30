package com.internousdev.Alexandria.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.MasterCategoryDAO;
import com.internousdev.Alexandria.dao.ProductInfoDAO;
import com.internousdev.Alexandria.dto.MasterCategoryDTO;
import com.internousdev.Alexandria.dto.ProductInfoDTO;
import com.internousdev.Alexandria.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{

	Map<String,Object> session;
	private List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
	private List<ProductInfoDTO> productInfoDTOListByRank = new ArrayList<ProductInfoDTO>();

	public String execute() {

		//ログインしていない場合、仮のユーザーIDを作成します
		 if (!(session.containsKey("loginId")) && !(session.containsKey("tempUserId"))) {
			 CommonUtility commonUtility = new CommonUtility();
			 session.put("tempUserId", commonUtility.getRandomTempUserId());
			 String faceShots = "./img/mypage.png";
			 session.put("faceShots", faceShots);
		}

		if(!session.containsKey("logined")) {
			session.put("logined", 0);
		}

		//カテゴリーリストを取得します
		List<MasterCategoryDTO> masterCategoryDTOList  = new ArrayList<MasterCategoryDTO>();
		MasterCategoryDAO masterCategoryDAO = new MasterCategoryDAO();
		masterCategoryDTOList = masterCategoryDAO.getMasterCategory();
		session.put("masterCategoryDTOList", masterCategoryDTOList);

		//カテゴリーIDの保存
		session.put("categoryId", masterCategoryDTOList.get(0).getId()-1);

		//商品情報の取得(文学)
		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		productInfoDTOList = productInfoDAO.getProductInfoListOfCategory(1);
		
		//ランクの設定
		CommonUtility commonUtility = new CommonUtility();
		productInfoDTOList = commonUtility.createStarRank(productInfoDTOList, productInfoDAO.getTotalRank());
		session.put("productInfoDTOList",productInfoDTOList);

		//商品ランキングを取得します
		productInfoDTOListByRank = productInfoDAO.getProductInfoByRank();
		session.put("productInfoDTOListByRank", productInfoDTOListByRank);

		return SUCCESS;
	}

	public Map<String,Object> setSession() {
		// TODO 自動生成されたメソッド・スタブ
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}
}
