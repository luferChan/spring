package com.te.empl.utils;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 
 * 	时间工具类
 * @author Administrator
 *
 */
public class DateTimeUtil implements Serializable{

	/**
	 *  获取当前时间
	 */
	private static final long serialVersionUID = -2622186353055566348L;
	
	public static Date getCurrentTime(){
		 return new Date();
	}
	//将DATE转换为字符串
	public static String dateToString(Date date,String format){
		return new SimpleDateFormat(format).format(date);
	}

	//将日期格式的字符串转换为时间
	public static Date stringToDate(String str,String format){
		try {
			return new SimpleDateFormat(format).parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getCurrentTime();
	}
}
