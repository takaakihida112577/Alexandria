package com.internousdev.Alexandria.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class InputChecker {

	//propertyName=検索する文字列の名称,value=検索する文字列
	//minLength=最小文字数,maxlength=最大文字数
	//以下をコメントでまとめて文字種と呼びます
	//availableAlphabeticCharacters=半角英字
	//availableKanji=漢字
	//availableHiragana=ひらがな
	//availableHalfWidthDigit=半角数字
	//availableHalfWidthSymbols=半角記号
	//availableKatakana=カタカナ
	//availableFullWidthSymbols=全角記号

	public List<String> doCheck(String propertyName,String value,int minLength,int maxLength,boolean availableAlphabeticCharacters,boolean availableKanji,boolean availableHiragana,boolean availableHalfWidthDigit,boolean availableHalfWidthSymbols,boolean availableKatakana,boolean availableFullWidthSymbols){

		//検証した結果を入れるList
		List<String> stringList = new ArrayList<String>();
		List<String> characterTypeList = new ArrayList<String>();

		//入力欄を空白かどうかを検証します
		if(StringUtils.isEmpty(value)){
			stringList.add(propertyName+"を入力してください。");
		}

		//入力欄が最小文字数以上、最大文字数以下かどうか検証します
		if(value.length()<minLength || value.length()>maxLength){
			stringList.add(propertyName + "ば" + minLength + "文字以上" + maxLength + "文字以下で入力してください。");
		}

		//入力された文字のタイプから何を判別するか決めます
		//boolean型の引数にfalseかtrueを入れます。
		String regularExpression = "";
		String errorExpression = "";


		//以下から文字種のを判定する為の文字列作成
		//例）姓=半角英語(a-zA-Z)、漢字(一-龯)、ひらがな(ぁ-ん)  [a-zA-Z一-龯ぁ-ん]+

		if(availableAlphabeticCharacters || availableKanji || availableHiragana || availableHalfWidthDigit || availableHalfWidthSymbols||availableKatakana||availableFullWidthSymbols){
			regularExpression = "[";
		}

		if(!(availableAlphabeticCharacters) || !(availableKanji) || !(availableHiragana) || !(availableHalfWidthDigit) || !(availableHalfWidthSymbols)|| !(availableKatakana)|| !(availableFullWidthSymbols)){
			errorExpression = "[^";
		}

		if(availableAlphabeticCharacters || availableKanji || availableHiragana || availableHalfWidthDigit || availableHalfWidthSymbols||availableKatakana||availableFullWidthSymbols){
			regularExpression = "[^";
		}
		if(!(availableAlphabeticCharacters) || !(availableKanji) || !(availableHiragana) || !(availableHalfWidthDigit) || !(availableHalfWidthSymbols)|| !(availableKatakana)|| !(availableFullWidthSymbols)){
			errorExpression = "[^";
		}

		if(availableAlphabeticCharacters){
			regularExpression +="a-zA-Z";
				characterTypeList.add("半角英字");
		}else{
			errorExpression += "a-zA-Z";
		}

		if(availableKanji){
			regularExpression +="一-龯";
			characterTypeList.add("漢字");
		}else{
			errorExpression +="一-龯";
		}

		if(availableHiragana){
			regularExpression +="ぁ-ん";
			characterTypeList.add("ひらがな");
		}else{
			errorExpression +="ぁ-ん";
		}

		if(availableHalfWidthDigit){
			regularExpression +="0-9";
			characterTypeList.add("半角数字");
		}else{
			errorExpression+="0-9";
		}

		if(availableHalfWidthSymbols){
			regularExpression +="@.,;:!#$%&'*+-/=?^_`{|}~";
			characterTypeList.add("半角記号");
		}else{
			errorExpression +="@.,;:!#$%&'*+-/=?^_`{|}~";
		}

		if(availableKatakana){
			regularExpression +="ァ-ヺ";
			characterTypeList.add("カタカナ");
		}else{
			errorExpression +="ァ-ヺ";
		}

		if(availableFullWidthSymbols){
			regularExpression +="＠．，；：！＃＄％＆’＊＋―／＝？＾＿｀｛｜｝～";
			characterTypeList.add("全角記号");
		}else{
			errorExpression +="＠．，；：！＃＄％＆’＊＋―／＝？＾＿｀｛｜｝～";
		}

		if(!StringUtils.isEmpty(regularExpression)){
			regularExpression +="]+";
		}
		if(!StringUtils.isEmpty(errorExpression)){
			errorExpression +="]+";
		}

		//作成した文字種に応じてエラーメッセージを作成
		String characterType = "";
		for(int i = 0;i < characterTypeList.size();i++){
			if(i == 0){
				characterType += characterTypeList.get(i).toString();
			}else{
				characterType += "、" + characterTypeList.get(i).toString();
			}
		}
		if(errorExpression.equals("")){
			if(value.matches(regularExpression)){
				stringList.add(propertyName + "は" + characterType + "で入力してください。");
			}
		}else{
			if(value.matches(regularExpression)||(!value.matches(errorExpression)&&!value.equals(""))){
				stringList.add(propertyName + "は" + characterType + "で入力してください。");
			}
		}

		return stringList;

	}

	//電話番号の判定
	public List<String> doTelNumberCheck(String propertyName,String value,int length){
		//検証した結果を入れるList
		List<String> stringList = new ArrayList<String>();

		//入力欄が空白かどうか検証します
		if(StringUtils.isEmpty(value)){
			stringList.add(propertyName+"を入力してください");
		}

		//入力欄が最小文字数以上、最小文字数以下かどうか検証します
		if(!(value.length() == 13)){
			stringList.add(propertyName+"は"+length+"文字で入力してください。");
		}

		//***-****-****の文字種で検証します
		if(!value.matches("[0-9]{3}-[0-9]{4}-[0-9]{4}")){
			stringList.add("***-****-****の形式で入力してください");
		}

		return stringList;
	}

	//郵便番号の判定
	public List<String> doPostalCheck(String propertyName,String value,int length){
		//検証した結果を入れるList
		List<String> stringList = new ArrayList<String>();

		//入力欄が空白かどうか検証します
		if(StringUtils.isEmpty(value)){
			stringList.add(propertyName+"を入力してください");
		}

		//入力欄が最小文字数以上、最小文字数以下かどうか検証します
		if(!(value.length() == 8)){
			stringList.add(propertyName+"は"+length+"文字で入力してください。");
		}

		//***-****の文字種で検証します
		if(!value.matches("[0-9]{3}-[0-9]{4}")){
			stringList.add("***-****-****の形式で入力してください");
		}
		return stringList;
	}

	//一度目のパスワードと二度目のパスワードが同じかを検証します。
	public List<String> doPasswordCheck(String password,String reConfirmationPassword){
		List<String> stringList = new ArrayList<String>();
		if(!(password.equals(reConfirmationPassword))){
			stringList.add("入力されたパスワードが異なります。");
		}
		return stringList;
	}
}
