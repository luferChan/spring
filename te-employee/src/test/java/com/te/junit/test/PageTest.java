package com.te.junit.test;

import org.junit.Test;

import com.te.empl.utils.PageUtil;

public class PageTest {
	
	@Test
	public void Test(){
		
		System.out.println(PageUtil.pack(15, 150, 1));
		System.out.println(PageUtil.pack(15, 152, 1));
	}
	
}
