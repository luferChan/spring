package com.te.empl.utils;

import java.io.Serializable;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class EncryptUtil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5677525954605633802L;
	
	/**
	 *  md5加密字符串方法
	 * @param str
	 * @return
	 */
	public static String md5(String str){
		
		if(StringUtils.isEmpty(str)){
			return "";
		}
		return DigestUtils.md5Hex(str);
	}
	

	
}
