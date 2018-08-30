package com.internousdev.Alexandria.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.MasterCategoryDAO;
import com.internousdev.Alexandria.dao.ProductInfoDAO;
import com.internousdev.Alexandria.dao.ReviewInfoDAO;
import com.internousdev.Alexandria.dto.MasterCategoryDTO;
import com.internousdev.Alexandria.dto.ProductInfoDTO;
import com.internousdev.Alexandria.dto.ReviewInfoDTO;
import com.internousdev.Alexandria.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailsAction extends ActionSupport implements SessionAware{

	private int productId;
	private int categoryId;
	private Map<String,Object> session;
	private ProductInfoDTO productInfoDTO = new ProductInfoDTO();
	private List<ReviewInfoDTO> reviewInfoDTOList = new ArrayList<ReviewInfoDTO>();
	private List<ProductInfoDTO> productInfoListRelevance = new ArrayList<ProductInfoDTO>();

	public String execute() {

		//セッション切れ対策
		if(!session.containsKey("masterCategoryDTOList")) {
			List<MasterCategoryDTO> masterCategoryDTOList  = new ArrayList<MasterCategoryDTO>();
			MasterCategoryDAO masterCategoryDAO = new MasterCategoryDAO();
			masterCategoryDTOList = masterCategoryDAO.getMasterCategory();
			session.put("masterCategoryDTOList", masterCategoryDTOList);
		}

		//商品詳細情報取得します
		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		productInfoDTO = productInfoDAO.getProductInfoDetails(productId);
		CommonUtility commonUtility = new CommonUtility();
		productInfoDTO = commonUtility.createStarRank(productInfoDTO, productInfoDAO.getTotalRank());
		session.put("id", productInfoDTO .getId());
		session.put("productId", productInfoDTO .getProductId());
		session.put("productName", productInfoDTO.getProductName());
		session.put("productShortDescription", productInfoDTO.getProductShortDescription());
		session.put("productDescription", productInfoDTO.getProductDescription());
		session.put("categroyId", productInfoDTO.getCategoryId());
		session.put("productImage", productInfoDTO.getProductImage());
		session.put("price", productInfoDTO.getPrice());
		session.put("releaseDate", productInfoDTO.getReleaseDate());
		session.put("releaseCompany", productInfoDTO.getReleaseCompany());
		session.put("rank", productInfoDTO.getRank());
		System.out.println("productInfoDTO.getRank():"+productInfoDTO.getRank());

		//商品個数の数を設定します
		List<Integer> productCountList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		session.put("productCountList", productCountList);

		//商品のランクを算出します


		//関連商品を取得します
		if(!productInfoDTO.equals(null)) {
			productInfoListRelevance = productInfoDAO.getProductInfoListRelevance(categoryId, productId, 0, 4);
			session.put("productInfoListRelevance", productInfoListRelevance);
		}

		//レビュー情報を取得します
		ReviewInfoDAO reviewInfoDAO = new ReviewInfoDAO();
		reviewInfoDTOList = reviewInfoDAO.getReviewInfoDTOList(productId);
		session.put("reviewInfoDTOList", reviewInfoDTOList);
		return SUCCESS;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}

}
