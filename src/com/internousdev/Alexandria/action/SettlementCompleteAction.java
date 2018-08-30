package com.internousdev.Alexandria.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.dao.CartInfoDAO;
import com.internousdev.Alexandria.dao.HistoryInfoDAO;
import com.internousdev.Alexandria.dao.ProductInfoDAO;
import com.internousdev.Alexandria.dao.UserInfoDAO;
import com.internousdev.Alexandria.dto.AddressInfoDTO;
import com.internousdev.Alexandria.dto.CartInfoDTO;
import com.internousdev.Alexandria.dto.HistoryInfoDTO;
import com.internousdev.Alexandria.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementCompleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;

	public String execute(){
		int count = 0;

		@SuppressWarnings("unchecked")
		ArrayList<HistoryInfoDTO> historyInfoDTOList = (ArrayList<HistoryInfoDTO>)session.get("historyInfoDTOList");

		@SuppressWarnings("unchecked")
		ArrayList<AddressInfoDTO> addressInfoDTOList = (ArrayList<AddressInfoDTO>)session.get("addressInfoDTOList");

		//購入情報リストに宛先情報IDを追加
		for(int i=0;i<historyInfoDTOList.size();i++){
			historyInfoDTOList.get(i).setAddressId(addressInfoDTOList.get(0).getId());
		}

		//ランクのカウント1アップ
		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		for(int i=0;i<historyInfoDTOList.size();i++){
			productInfoDAO.updateRank(historyInfoDTOList.get(i).getProductId());
		}

		//商品購入履歴の作成
		HistoryInfoDAO historyInfoDAO = new HistoryInfoDAO();
		for(int i=0;i<historyInfoDTOList.size();i++){
			count += historyInfoDAO.createHistoryInfo(String.valueOf(session.get("loginId")), historyInfoDTOList.get(i).getProductId(), historyInfoDTOList.get(i).getProductCount(), historyInfoDTOList.get(i).getSubTotal(), historyInfoDTOList.get(i).getAddressId());
		}

		//カートから来た場合はカート情報の削除を行います
		if(String.valueOf(session.get("settlementFlg")).equals("cart")){
			System.out.println("カート処理");
			CartInfoDAO cartInfoDAO = new CartInfoDAO();
			for(int i=0;i<historyInfoDTOList.size();i++){
				count += cartInfoDAO.deleteCartInfo(String.valueOf(historyInfoDTOList.get(i).getCartId()));
			}

			//削除した後のカート情報を取得します
			if(count > 0){
				List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();
				cartInfoDTOList = cartInfoDAO.getCartInfoDTOList(String.valueOf(session.get("loginId")));
				Iterator<CartInfoDTO> iterator = cartInfoDTOList.iterator();
				if(iterator.hasNext()){
					cartInfoDTOList = null;
				}
				session.put("cartInfoDTOList", cartInfoDTOList);

				//削除した後の合計金額を取得します
				//String.valueOf(session.get("loginId")) => "sample"
				int totalPrice = cartInfoDAO.getTotalPrice(String.valueOf(session.get("loginId")));
				session.put("totalPrice", totalPrice);

				//settlementFlgをremoveしカートから来た履歴を削除します
				session.remove("settlementFlg");
			}
		}

		//ポイント支払いを行います
		if(Integer.parseInt(session.get("point").toString()) >= Integer.parseInt(session.get("totalPrice").toString())){
			UserInfoDAO userInfoDAO = new UserInfoDAO();
			userInfoDAO.settlementPoint(Integer.parseInt(session.get("point").toString()), Integer.parseInt(session.get("totalPrice").toString()), String.valueOf(session.get("loginId")));
			session.put("point", Integer.parseInt(session.get("point").toString()) - Integer.parseInt(session.get("totalPrice").toString()));
		}

		//完了メッセージリストを作成します
		String[] completeWordList;
		CommonUtility commonUtility = new CommonUtility();
		completeWordList = commonUtility.parseCompleteWord("ご購入ありがとうございました！！");
		session.put("completeWordList", completeWordList);

		return SUCCESS;
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
