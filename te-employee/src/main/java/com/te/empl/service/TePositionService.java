package com.te.empl.service;

import com.te.empl.support.JSONReturn;

public abstract interface TePositionService {

	JSONReturn addPosition(Long departmentId, String name, String description,String acctName);
	
}
