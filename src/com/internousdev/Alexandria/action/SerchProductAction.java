package com.internousdev.Alexandria.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.MasterCategoryDAO;
import com.internousdev.Alexandria.dao.ProductInfoDAO;
import com.internousdev.Alexandria.dto.MasterCategoryDTO;
import com.internousdev.Alexandria.dto.PaginationDTO;
import com.internousdev.Alexandria.dto.ProductInfoDTO;
import com.internousdev.Alexandria.util.CommonUtility;
import com.internousdev.Alexandria.util.InputChecker;
import com.internousdev.Alexandria.util.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class SerchProductAction extends ActionSupport implements SessionAware{
	private String categoryId;
	private String keywords;
	private String pageNo;
	private List<String> keywordsErrorMessageList = new ArrayList<String>();
	private List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
	private Map<String,Object> session;

	public String execute() {

		//セッション切れ対策
		if(!session.containsKey("masterCategoryDTOList")) {
			List<MasterCategoryDTO> masterCategoryDTOList  = new ArrayList<MasterCategoryDTO>();
			MasterCategoryDAO masterCategoryDAO = new MasterCategoryDAO();
			masterCategoryDTOList = masterCategoryDAO.getMasterCategory();
			session.put("masterCategoryDTOList", masterCategoryDTOList);
		}

		//入力内容のチェック
		InputChecker inputChecker = new InputChecker();
		if(keywords==null) {
			keywords = "";
		}
		keywordsErrorMessageList = inputChecker.doCheck("検索ワード", keywords, 0, 16, true, true, true, true, false, true, true);
		session.put("keywordsErrorMessageList", keywordsErrorMessageList);

		//カテゴリごとに検索します
		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		switch(categoryId) {
			case "0":
				productInfoDTOList = productInfoDAO.getProductInfoListSerchAll(keywords.replaceAll("　", " ").split(" "));
				break;
			default:
				productInfoDTOList = productInfoDAO.getProductInfoListSerch(keywords.replaceAll("　", " ").split(" "), categoryId);
				break;
		}


		//ランクを設定します
		CommonUtility commonUtility = new CommonUtility();
		System.out.println("nonon");
		productInfoDTOList = commonUtility.createStarRank(productInfoDTOList, productInfoDAO.getTotalRank());

		//検索結果がない場合の処理です
		Iterator<ProductInfoDTO> iterator = productInfoDTOList.iterator();
		if(!(iterator.hasNext())) {
			productInfoDTOList = null;
		}

		//検索結果がある場合はページ番号を発行します。
		if(!(productInfoDTOList==null)) {
			Pagination pagination = new Pagination();
			PaginationDTO paginationDTO = new PaginationDTO();
			if(pageNo==null) {
				paginationDTO = pagination.initialize(productInfoDTOList, 8);
			}else {
				paginationDTO = pagination.getPage(productInfoDTOList, 8, pageNo);
			}

			session.put("productInfoDTOList", paginationDTO.getCurrentProductInfoPage());
			session.put("totalPageSize", paginationDTO.getTotalPageSize());
			session.put("currentPageNo", paginationDTO.getCurrentPageNo());
			session.put("totalRecordSize", paginationDTO.getTotalRecordSize());
			session.put("startRecordNo", paginationDTO.getStartRecordNo());
			session.put("endRecordNo", paginationDTO.getEndRecordNo());
			session.put("previousPage", paginationDTO.hasPreviousPage());
			session.put("previousPageNo", paginationDTO.getPreviousPageNo());
			session.put("nextPage", paginationDTO.hasNextPage());
			session.put("nextPageNo", paginationDTO.getNextPageNo());
		}else {
			session.put("productInfoDTOList", productInfoDTOList);
		}
		return SUCCESS;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
}
