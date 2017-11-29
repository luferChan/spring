package com.te.empl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.te.empl.dao.TeModuleDao;
import com.te.empl.dto.TeModuleDto;
import com.te.empl.model.TeModule;
import com.te.empl.service.TeModuleService;
import com.te.empl.support.JSONReturn;
import com.te.empl.utils.Logable;

@Service
@Transactional(readOnly=true)
public class TeModuleServiceImpl extends Logable implements TeModuleService {
	
	@Autowired
	private TeModuleDao teModuleDao;

	@Override
	public JSONReturn getMenu() {
		// 获取数据表的所有数据
		List<TeModule> moduleList = teModuleDao.findAll();
		if(CollectionUtils.isEmpty(moduleList)){
			error("未获取到系统菜单!");
			return JSONReturn.buildFailure("未获取到系统菜单...");
		}
		List<TeModuleDto> dataList = new ArrayList<TeModuleDto>();
		for(TeModule md : moduleList){
			dataList.add(new TeModuleDto(md.getCode(), md.getSuperCode(), md.getName(), md.getPage(), md.getLevel()));			
		}
		return JSONReturn.buildSuccess(dataList);
	}
}
