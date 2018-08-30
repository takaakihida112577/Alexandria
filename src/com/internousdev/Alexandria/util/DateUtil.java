package com.internousdev.Alexandria.util;

import java.text.SimpleDateFormat;
import java.util.Date;

//現在時刻を取得するクラスです

public class DateUtil {
	public String getDate(){
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

		return simpleDateFormat.format(date);
	}
}
