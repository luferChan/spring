package com.te.empl.service;

import com.te.empl.support.JSONReturn;

public abstract interface TePositionService {

	public abstract JSONReturn addPosition(Long departmentId, String name, String description,String acctName);
	
}
