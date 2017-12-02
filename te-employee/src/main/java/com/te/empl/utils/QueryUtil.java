package com.te.empl.utils;

import org.apache.commons.lang.StringUtils;

public class QueryUtil {
	
	public static String packLink(String key){
		//三步运算符判断传入的需要搜索的部门名称参数是否为空
		key = StringUtils.isEmpty(key) ? "" : key ;
		return new StringBuffer().append("%").append(key).append("%").toString();
	}
	
}
