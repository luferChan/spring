package com.te.junit.test;

import org.junit.Test;

import com.te.empl.utils.DateTimeUtil;

public class DateTest {

	@Test
	public void Test(){
		
		System.out.println(DateTimeUtil.dateToString(DateTimeUtil.getCurrentTime(), "yyyy-MM-dd HH:mm:ss"));
		System.out.println(DateTimeUtil.stringToDate("2015-02-12", "yyyy-MM-dd"));
	}
}
