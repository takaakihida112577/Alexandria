package com.internousdev.Alexandria.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.Alexandria.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class HeadShotsConfirmAction extends ActionSupport implements SessionAware{

	private File userImage;
	private String userImageFileName;
	private Map<String,Object> session;
	private List<String> imageFilePathErrorMessageList = new ArrayList<String>();
	private String imageFilePathError;

	public String execute(){
		String result = ERROR;

		//画像ファイルが選択されているか、確認
		if(userImage != null){
			imageFilePathError = null;
		}else{
			imageFilePathErrorMessageList.add("画像ファイルを選んでください");
		}

		//画像のアップロード
		if(imageFilePathErrorMessageList.size() == 0){
			//画像のファイルパス作成
			String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("img");

			//重複防止の為、画像ファイル名の変更
			CommonUtility commonUtility = new CommonUtility();
			userImageFileName = commonUtility.getRandomTempUserId() + userImageFileName;

			//新しいファイルを作る
			File fileToCreate = new File(filePath,userImageFileName);

			try{
				//サーバー上に一時保存した画像を正式な場所にコピーする
				FileUtils.copyFile(userImage, fileToCreate);
				System.out.println("userImageFileName"+userImageFileName);
				userImageFileName = "./img/"+userImageFileName;
				session.put("userImageFileName", userImageFileName);
				result = SUCCESS;
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{

		}

		return result;
	}

	public File getUserImage(){
		return userImage;
	}
	public void setUserImage(File userImage){
		this.userImage = userImage;
	}

	public String getUserImageFileName(){
		return userImageFileName;
	}
	public void setUserImageFileName(String userImageFileName){
		this.userImageFileName = userImageFileName;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object>session){
		this.session = session;
	}
}
