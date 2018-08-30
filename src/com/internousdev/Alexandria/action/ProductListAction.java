package com.internousdev.Alexandria.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.MasterCategoryDAO;
import com.internousdev.Alexandria.dao.ProductInfoDAO;
import com.internousdev.Alexandria.dto.MasterCategoryDTO;
import com.internousdev.Alexandria.dto.PaginationDTO;
import com.internousdev.Alexandria.dto.ProductInfoDTO;
import com.internousdev.Alexandria.util.CommonUtility;
import com.internousdev.Alexandria.util.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class ProductListAction extends ActionSupport implements SessionAware{

	private int categoryId;
	private Map<String,Object> session;
	private List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
	private PaginationDTO paginationDTO = new PaginationDTO();

	public String execute() {

		System.out.println("実行されてる");
		//セッション切れ対策
		if(!session.containsKey("masterCategoryDTOList")) {
			List<MasterCategoryDTO> masterCategoryDTOList  = new ArrayList<MasterCategoryDTO>();
			MasterCategoryDAO masterCategoryDAO = new MasterCategoryDAO();
			masterCategoryDTOList = masterCategoryDAO.getMasterCategory();
			session.put("masterCategoryDTOList", masterCategoryDTOList);
		}

		//カテゴリーIDの保存
		session.put("categoryId", categoryId-1);

		//商品カテゴリから商品情報を取得します
		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		productInfoDTOList = productInfoDAO.getProductInfoListOfCategory(categoryId);
		CommonUtility commonUtility = new CommonUtility();
		System.out.println("nonon");
		productInfoDTOList = commonUtility.createStarRank(productInfoDTOList, productInfoDAO.getTotalRank());
		System.out.println("yesyes");


		//ページを作成します
		Pagination pagination = new Pagination();
		paginationDTO = pagination.initialize(productInfoDTOList, 8);
		session.put("totalPageSize", paginationDTO.getTotalPageSize());
		session.put("currentPageNo", paginationDTO.getCurrentPageNo());
		session.put("totalRecordSize", paginationDTO.getTotalPageSize());
		session.put("startRecordNo", paginationDTO.getStartRecordNo());
		session.put("endRecordNo", paginationDTO.getEndRecordNo());
		session.put("pageNumberList", paginationDTO.getPageNumberList());
		session.put("productInfoDTOList", paginationDTO.getCurrentProductInfoPage());
		session.put("hasNextPage", paginationDTO.hasNextPage());
		session.put("hasPreviousPage", paginationDTO.hasPreviousPage());
		session.put("nextPageNo", paginationDTO.getNextPageNo());
		session.put("previousPageNo", paginationDTO.getPreviousPageNo());

		return SUCCESS;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public PaginationDTO getPaginationDTO() {
		return paginationDTO;
	}

	public void setPaginationDTO(PaginationDTO paginationDTO) {
		this.paginationDTO = paginationDTO;
	}

	public List<ProductInfoDTO> getProductInfoDTOList(){
		return productInfoDTOList;
	}

	public void setProductInfoDTOList(List<ProductInfoDTO> productInfoDTOList ) {
		this.productInfoDTOList = productInfoDTOList ;
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
