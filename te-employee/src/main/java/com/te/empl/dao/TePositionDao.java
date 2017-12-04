package com.te.empl.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.te.empl.dao.support.AbstractDao;
import com.te.empl.model.TePosition;

@Repository
public class TePositionDao extends AbstractDao<TePosition> implements Serializable{
	
	private static final long serialVersionUID = 2708518932668824383L;
	public static final String ID = "id";
	public static final String CREATOR = "creator";
	public static final String STATE = "state";
	public static final String DEPARTMENT = "department";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	@Override
	public Class<TePosition> getEntityClass() {
		// TODO Auto-generated method stub
		return TePosition.class;
	}
}
