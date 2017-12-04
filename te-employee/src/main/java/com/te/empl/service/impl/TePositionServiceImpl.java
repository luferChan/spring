package com.te.empl.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.te.empl.constant.db.TeDepartmentState;
import com.te.empl.constant.db.TePositionState;
import com.te.empl.dao.TeDepartmentDao;
import com.te.empl.dao.TePositionDao;
import com.te.empl.model.TeDepartment;
import com.te.empl.model.TePosition;
import com.te.empl.service.TePositionService;
import com.te.empl.support.JSONReturn;
import com.te.empl.utils.DateTimeUtil;
import com.te.empl.utils.Logable;

@Service
@Transactional(readOnly = true)
public class TePositionServiceImpl extends Logable implements TePositionService {

	@Autowired
	private TePositionDao tePositionDao;
	@Autowired
	private TeDepartmentDao teDepartmentDao;
	
	/**
	 *   添加职位
	 */
	@Override
	@Transactional
	public JSONReturn addPosition(Long departmentId, String name,
			String description,String acctName) {
		info("{}正在添加新职位信息！",acctName);
		
		if(StringUtils.isEmpty(name)){
			warning("\t添加失败，输入的职位名称为空！");
			return JSONReturn.buildFailure("添加失败，职位名称为空！");
		}
		
		TeDepartment teDepartment = teDepartmentDao.findById(departmentId);
		if(teDepartment == null || teDepartment.getState() == TeDepartmentState.delete.getState()){
			warning("\t添加失败，数据库中存入的部门数据不存在或已被删除！");
			return JSONReturn.buildFailure("添加失败，原部门数据不存在!");
		}
		
		TePosition tePosition = new TePosition(DateTimeUtil.getCurrentTime(), acctName,
				TePositionState.normal.getState(), departmentId, name, description);
		tePositionDao.save(tePosition);
		info("创建职位成功，保存的数据为：{}",tePosition.toString());
		
		return JSONReturn.buildSuccess("添加职位成功！");
	}

}
