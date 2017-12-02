package com.te.empl.service;

import com.te.empl.support.JSONReturn;

public interface TeDepartmentService {

	public abstract JSONReturn addDepartment(String name, String description, String acctName);

	public abstract JSONReturn findDepartmentList(String search_name, int page,
			String acctName);

}
