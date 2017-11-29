package com.te.empl.dao;

import org.springframework.stereotype.Repository;

import com.te.empl.dao.support.AbstractDao;
import com.te.empl.model.TeModule;

@Repository
public class TeModuleDao extends AbstractDao<TeModule>{
	@Override
	public Class<TeModule> getEntityClass() {
		// TODO Auto-generated method stub
		return TeModule.class;
	}
}
