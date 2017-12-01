package com.te.empl.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.te.empl.dao.support.AbstractDao;
import com.te.empl.model.TeDepartment;

@Repository
public class TeDepartmentDao extends AbstractDao<TeDepartment> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8956575292104244432L;

	@Override
	public Class<TeDepartment> getEntityClass() {
		// TODO Auto-generated method stub
		return TeDepartment.class;
	}
}
