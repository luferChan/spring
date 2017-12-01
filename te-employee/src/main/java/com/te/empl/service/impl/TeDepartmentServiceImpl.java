package com.te.empl.service.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.te.empl.constant.db.TeDepartmentState;
import com.te.empl.dao.TeDepartmentDao;
import com.te.empl.model.TeDepartment;
import com.te.empl.service.TeDepartmentService;
import com.te.empl.support.JSONReturn;
import com.te.empl.utils.DateTimeUtil;
import com.te.empl.utils.Logable;


@Service
@Transactional(readOnly = true)
public class TeDepartmentServiceImpl extends Logable implements TeDepartmentService {
	@Autowired
	private TeDepartmentDao teDepartmentDao;
	
	@Override
	@Transactional
	public JSONReturn addDepartment(String name, String description,
			String acctName) {
		info("新增部门信息...");
		if(StringUtils.isEmpty(name)){
			error("\t新增部门信息失败，输入的部门名称name为空，操作者为{}",acctName);
			return JSONReturn.buildFailure("部门名称为空...");
		}
		TeDepartment teDepartment = new TeDepartment(DateTimeUtil.getCurrentTime(), acctName, TeDepartmentState.normal.getState(), name, description);
		teDepartmentDao.save(teDepartment);
		info("\t新增部门信息成功，部门信息为：{}",teDepartment.toString());
		return JSONReturn.buildSuccess("部门添加成功！");
	}
}
