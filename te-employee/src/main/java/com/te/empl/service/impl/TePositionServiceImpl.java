package com.te.empl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.te.empl.constant.PageConstant;
import com.te.empl.constant.TimeFormatConstant;
import com.te.empl.constant.db.TeDepartmentState;
import com.te.empl.constant.db.TePositionState;
import com.te.empl.dao.TeDepartmentDao;
import com.te.empl.dao.TePositionDao;
import com.te.empl.dto.TePositionDto;
import com.te.empl.model.TeDepartment;
import com.te.empl.model.TePosition;
import com.te.empl.service.TePositionService;
import com.te.empl.support.JSONReturn;
import com.te.empl.utils.DateTimeUtil;
import com.te.empl.utils.Logable;
import com.te.empl.utils.PageUtil;

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
	
	@Override
	public JSONReturn getPositionList(Long departmentId,String search_name, int page,String acctName) {
		List<TePosition> positions = tePositionDao.getPositionList(departmentId,search_name,page,PageConstant.DEFAULT_LINE);
		if(CollectionUtils.isEmpty(positions)){
			return JSONReturn.buildFailure("未获取到相关数据！");
		}
		List<TePositionDto> posList = new ArrayList<TePositionDto>();
		TeDepartment teDepartment = null;
		for(TePosition pt : positions){
			teDepartment = teDepartmentDao.findById(pt.getDepartment());
			
			posList.add(new TePositionDto(pt.getId(), pt.getName(), DateTimeUtil.dateToString(pt.getCreateTime(), TimeFormatConstant.YYYY_MM_DD), pt.getCreator(), teDepartment.getName(), pt.getDescription()));
		}
		return JSONReturn.buildSuccess(posList);
	}
	
	@Override
	@Transactional
	public JSONReturn deletePosition(Long id, String acctName) {
		// TODO Auto-generated method stub
		info("{}正在删除职位信息，待删除职位id为{}",acctName,id);
		TePosition tePosition = tePositionDao.findById(id);
		if(tePosition == null || tePosition.getState() == TePositionState.delete.getState()){
			error("\t该职位信息不存在或已被删除！");
			return JSONReturn.buildFailure("该数据不存在或已被删除！");
		}
		tePosition.setState(TePositionState.delete.getState());
		tePositionDao.update(tePosition);
		info("删除职位成功！");
		return JSONReturn.buildSuccess("删除职位成功！");
	}
	
	@Override
	public JSONReturn getPositionPage(Long departmentId, String search_name,
			int page, String acctName) {
		;
		return JSONReturn.buildSuccess(PageUtil.pack(PageConstant.DEFAULT_LINE, tePositionDao.getPositionPage(departmentId,search_name), page));
	}
	
	@Override
	@Transactional
	public JSONReturn editPosition(Long positionId,Long departmentId, String name,
			String description, String acctName) {
		if(StringUtils.isEmpty(name) || departmentId == -1 || departmentId == null){
			return JSONReturn.buildFailure("修改失败，职位名称为空或未选择上级部门！");
		}
		
		TePosition tePosition = tePositionDao.findById(positionId);
		if(tePosition.getState() == TePositionState.delete.getState() || tePosition == null){
			return JSONReturn.buildFailure("修改失败，该职位不存在或已被删除！");
		}
		if(tePosition.getDepartment()==departmentId && tePosition.getName().equals(name) 
				&& tePosition.getDescription().equals(description)){
			return JSONReturn.buildFailure("修改失败，修改信息与原数据一致。");
		}
		tePosition.setDepartment(departmentId);
		tePosition.setName(name);
		tePosition.setDescription(description);
		tePositionDao.update(tePosition);
		return JSONReturn.buildSuccess("修改职位信息成功！");
	}
}
