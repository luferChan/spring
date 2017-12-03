package com.te.empl.service;

import com.te.empl.support.JSONReturn;

public interface TeDepartmentService {

	public abstract JSONReturn addDepartment(String name, String description, String acctName);

	public abstract JSONReturn findDepartmentList(String search_name, int page,
			String acctName);

	public abstract JSONReturn findDepartmentPage(String search_name, int page,
			String acctName);

	public abstract JSONReturn deleteDepartment(Long id, String acctName);

	public abstract JSONReturn updateDepartment(Long id, String name,
			String description, String acctName);

}
