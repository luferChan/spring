package com.te.empl.utils;

import java.io.Serializable;

import com.te.empl.dto.PageDto;


/** 
 *   分页工具类
 * @author Administrator
 */
public class PageUtil implements Serializable{

	/**
	 *  count; //总数
	 *  total; //总页数
	 *  current; //当前页码
	 *  size; //每页显示多少行数据
	 */
	private static final long serialVersionUID = 4062992435961039536L;
	
	public static PageDto pack(int size,int count,int current){
		PageDto dto = new PageDto();
		dto.setSize(size);
		dto.setCurrent(current);
		dto.setCount(count);
		
		//计算总页数
		if(count % size > 0 ){
			dto.setTotal((count / size)+1);
		}
		else{
			dto.setTotal(count / size);
		}
		return dto;	
	}
	
	
}
