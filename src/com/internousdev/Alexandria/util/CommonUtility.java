package com.internousdev.Alexandria.util;

import java.util.List;

import com.internousdev.Alexandria.dto.ProductInfoDTO;

public class CommonUtility {

	//未ログイン時に仮userIdを発行します
	public String getRandomTempUserId(){
		String value="";
		double d;
		for(int i=1;i<=16;i++){
			d=Math.random() * 10;
			value = value+((int)d);
		}
		return value;
	}

	//複数商品の文字列を1ずつに分割します

	public String[] parseArrayList(String s){
		return s.split(", ",0);
	}

	//完了メッセージを1文字ずつに分解します
	public String[] parseCompleteWord(String completeWord){
		String[] stringList = new String[completeWord.length()];

		for(int i=0;i<completeWord.length();i++){
			String value = String.valueOf(completeWord.charAt(i));
			stringList[i] = value;
		}
		return stringList;
	}

	//★を表示するためにrankを加工します
	public List<ProductInfoDTO> createStarRank(List<ProductInfoDTO> productInfoDTOList,int[] rankData){
		int starRank = 0;
		for(int i=0;i<productInfoDTOList.size();i++){
			//星5
			if(productInfoDTOList.get(i).getRank() == rankData[1]){
				starRank = 5;
			}

			//星4
			if(rankData[0]<productInfoDTOList.get(i).getRank() && productInfoDTOList.get(i).getRank()<rankData[1]){
				starRank = 4;
			}

			//星3
			if(productInfoDTOList.get(i).getRank() == rankData[0]){
				starRank = 3;
			}

			//星2
			if(productInfoDTOList.get(i).getRank()<rankData[0] && rankData[2]<productInfoDTOList.get(i).getRank()){
				starRank = 2;
			}
			//星1
			if(productInfoDTOList.get(i).getRank()==rankData[2]){
				starRank = 1;
			}


			//星0
			if(productInfoDTOList.get(i).getRank()==0){
				starRank = 0;
			}
			System.out.println("starRank:"+starRank);
			productInfoDTOList.get(i).setRank(starRank);
		}
		return productInfoDTOList;
	}

	public ProductInfoDTO createStarRank(ProductInfoDTO productInfoDTO, int[] rankData) {
		// TODO 自動生成されたメソッド・スタブ
		int starRank = 0;
		if(productInfoDTO.getRank() == rankData[1]){
			starRank = 5;
		}

		//星4
		if(rankData[0]<productInfoDTO.getRank() && productInfoDTO.getRank()<rankData[1]){
			starRank = 4;
		}

		//星3
		if(productInfoDTO.getRank() == rankData[0]){
			starRank = 3;
		}

		//星2
		if(productInfoDTO.getRank()<rankData[0] && rankData[2]<productInfoDTO.getRank()){
			starRank = 2;
		}
		//星1
		if(productInfoDTO.getRank()==rankData[2]){
			starRank = 1;
		}


		//星0
		if(productInfoDTO.getRank()==0){
			starRank = 0;
		}
		productInfoDTO.setRank(starRank);
		return productInfoDTO;
	}
}
