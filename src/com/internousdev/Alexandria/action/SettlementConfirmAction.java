package com.internousdev.Alexandria.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.AddressInfoDAO;
import com.internousdev.Alexandria.dto.AddressInfoDTO;
import com.internousdev.Alexandria.dto.HistoryInfoDTO;
import com.internousdev.Alexandria.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementConfirmAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private String id;
	private String userId;
	private String tempUserId;
	private String productId;
	private String productCount;
	private String price;
	private String productName;
	private String productImage;
	private String releaseCompany;
	private String releaseDate;
	private String productShortDescription;
	private String productDescription;
	private String subTotal;
	private String settlementFlg;
	private int totalPrice;

	private Collection<String> checkList;

	public String execute(){

		String result = ERROR;
		totalPrice = 0;

		//商品詳細画面から遷移した場合の処理
		if(id.equals("0")){
			subTotal = String.valueOf(Integer.parseInt(price)*Integer.parseInt(productCount));
		}

		//カートから遷移した場合の処理
		if(settlementFlg != null){
			session.put("settlementFlg", settlementFlg);
		}

		//チェックされていない場合カートに戻りエラー表示
		if(checkList==null || checkList.toString().equals("[false]")){
			List<String> checkListErrorMessageList = new ArrayList<String>();
			checkListErrorMessageList.add("チェックされていません");
			session.put("checkListErrorMessageList", checkListErrorMessageList);
			return "checkError";
		}

			//テストモードloginId=sample
			AddressInfoDAO addressInfoDAO = new AddressInfoDAO();
			List<AddressInfoDTO> addressInfoDTOList = new ArrayList<AddressInfoDTO>();
			addressInfoDTOList = addressInfoDAO.getAddressInfoDTO(String.valueOf(session.get("loginId")));
			//宛先情報があるのか調べます
			Iterator<AddressInfoDTO> iterator = addressInfoDTOList.iterator();
			if(!(iterator.hasNext())){
				addressInfoDTOList = null;
			}
			session.put("addressInfoDTOList", addressInfoDTOList);

		//複数の商品情報を一つずつに分解し格納します
		List<HistoryInfoDTO> historyInfoDTOList = new ArrayList<HistoryInfoDTO>();
		CommonUtility commonUtility = new CommonUtility();

		String[] idList = commonUtility.parseArrayList(id);
		String[] productIdList = commonUtility.parseArrayList(productId);
		String[] productNameList = commonUtility.parseArrayList(productName);
		String[] productImageList = commonUtility.parseArrayList(productImage);
		String[] priceList = commonUtility.parseArrayList(price);
		String[] releaseCompanyList = commonUtility.parseArrayList(releaseCompany);
		String[] releaseDateList = commonUtility.parseArrayList(releaseDate);
		String[] productCountList = commonUtility.parseArrayList(productCount);
		String[] subTotalList = commonUtility.parseArrayList(subTotal);

		//チェックがついた商品をhistoryInfoDTOに格納します
		System.out.println(checkList);
		for(String value : checkList){
			for(int i=0;i<idList.length;i++){
				if(value.equals(idList[i])){
					HistoryInfoDTO historyInfoDTO = new HistoryInfoDTO();

					historyInfoDTO.setUserId(String.valueOf(session.get("loginId")));

					historyInfoDTO.setCartId(Integer.parseInt(idList[i]));
					historyInfoDTO.setProductId(Integer.parseInt(productIdList[i]));
					historyInfoDTO.setProductName(productNameList[i]);
					historyInfoDTO.setPrice(Integer.parseInt(priceList[i]));
					historyInfoDTO.setReleaseCompany(releaseCompanyList[i]);
					historyInfoDTO.setProductImage(productImageList[i]);
					historyInfoDTO.setProductCount(Integer.parseInt(productCountList[i]));
					historyInfoDTO.setSubTotal(Integer.parseInt(subTotalList[i]));
					try{
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
						historyInfoDTO.setReleaseDate(simpleDateFormat.parse(String.valueOf(releaseDateList[i])));
					}catch(ParseException e){
						e.printStackTrace();
					}
					System.out.println(productNameList[i]);
					historyInfoDTOList.add(historyInfoDTO);

					//合計金額を算出します
					totalPrice += Integer.parseInt(subTotalList[i]);
				}
			}
		}
		session.put("historyInfoDTOList", historyInfoDTOList);
		session.put("totalPrice", totalPrice);

		//ログインしていない場合ログイン画面に行きます
		if(!(session.containsKey("loginId"))){
			result = ERROR;
		}else{
			result = SUCCESS;
		}

		//return result;
		return result;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO 自動生成されたメソッド・スタブ
		this.session = session;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getUserId(){
		return userId;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getTempUserId(){
		return tempUserId;
	}

	public void setTempUserId(String tempUserId){
		this.tempUserId = tempUserId;
	}

	public String getProductId(){
		return productId;
	}

	public void setProductId(String productId){
		this.productId = productId;
	}

	public String getProductCount(){
		return productCount;
	}

	public void setProductCount(String productCount){
		this.productCount = productCount;
	}

	public String getPrice(){
		return price;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getProductName(){
		return productName;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductImage(){
		return productImage;
	}

	public void setProductImage(String productImage){
		this.productImage = productImage;
	}

	public String getReleaseCompany(){
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany){
		this.releaseCompany = releaseCompany;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}

	public String getProductShortDescription(){
		return productShortDescription;
	}

	public void setProductShortDescription(String productShortDescription){
		this.productShortDescription = productShortDescription;
	}

	public String getProductDescription(){
		return productDescription;
	}

	public void setProductDescription(String productDescription){
		this.productDescription = productDescription;
	}

	public String getSubTotal(){
		return subTotal;
	}

	public void setSubTotal(String subTotal){
		this.subTotal = subTotal;
	}

	public Collection<String> getCheckList(){
		return checkList;
	}

	public void setCheckList(Collection<String> checkList){
		this.checkList = checkList;
	}

	public String getSettlementFlg(){
		return settlementFlg;
	}

	public void setSettlementFlg(String settlementFlg){
		this.settlementFlg = settlementFlg;
	}

	public int getTotalPrice(){
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice){
		this.totalPrice = totalPrice;
	}
}
