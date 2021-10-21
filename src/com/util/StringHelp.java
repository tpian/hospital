package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StringHelp {


	public static Date convertFormStr(String birthday){
		if(birthday==null||"".equals(birthday.trim())){
			return null;
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				return sdf.parse(birthday);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	
	public static java.sql.Date convertFormUtilDate(java.util.Date date){
		if(date==null){
			return null;
		}else{
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			return sqlDate;
		}
	}
}
