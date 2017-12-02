package com.te.empl.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;


import com.te.empl.constant.PageConstant;
import com.te.empl.constant.TimeFormatConstant;
import com.te.empl.constant.db.TeDepartmentState;
import com.te.empl.dao.TeDepartmentDao;
import com.te.empl.dto.TeDepartmentDto;
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
	public JSONReturn addDepartment( String name, String description,
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
	
	@Override
	@Transactional
	public JSONReturn findDepartmentList(String search_name, int page,
			String acctName) {
		// 1.从数据库中将数据查询出来
		List<TeDepartment> departments = teDepartmentDao.findDepartmentList(search_name,page,PageConstant.DEFAULT_LINE);
		if(CollectionUtils.isEmpty(departments)){
			return JSONReturn.buildFailure("未获取到相关数据");
		}
		
		// 2.通过dto对数据列表进行转换
		List<TeDepartmentDto> dpmList = new ArrayList<TeDepartmentDto>();
		for(TeDepartment dp : departments){
			dpmList.add(new TeDepartmentDto(dp.getId(), dp.getName(), dp.getCreator(), DateTimeUtil.dateToString(dp.getCreatTime(), TimeFormatConstant.YYYY_MM_DD), dp.getDescrition()));
		}
		
		return JSONReturn.buildSuccess(dpmList);
	}
	
}
