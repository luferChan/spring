package com.te.empl.service;

import com.te.empl.support.JSONReturn;

public abstract interface TePositionService {

	public abstract JSONReturn addPosition(Long departmentId, String name, String description,String acctName);
	
	
	/**
	 * 获取首页职位数据
	 * @param acctName 
	 * @param page 
	 * @param search_name 
	 * @param acctName 
	 * @return
	 */
	public abstract JSONReturn getPositionList(Long departmentId,String search_name, int page, String acctName);


	public abstract JSONReturn deletePosition(Long id, String acctName);


	public abstract JSONReturn getPositionPage(Long departmentId,
			String search_name, int page, String acctName);


	public abstract JSONReturn editPosition(Long positionId,Long departmentId, String name,
			String description, String acctName);
	
}
