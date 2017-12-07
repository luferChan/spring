package com.te.empl.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.te.empl.constant.db.TePositionState;
import com.te.empl.dao.support.AbstractDao;
import com.te.empl.model.TePosition;
import com.te.empl.utils.QueryUtil;

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
	@SuppressWarnings("unchecked")
	public List<TePosition> getPositionList(String search_name, int page,
			int line) {
		if(StringUtils.isEmpty(search_name)){
			String query = "from TePosition where state = ? order by id desc";
			return findSession().createQuery(query).setInteger(0, TePositionState.normal.getState())
					.setFirstResult((page-1)*line).setMaxResults(page*line).list();
		}
		
		String query = "from TePosition where state = ? and name like ? order by id desc";
		return findSession().createQuery(query).setInteger(0, TePositionState.normal.getState()).setString(1, QueryUtil.packLink(search_name)).setFirstResult((page-1)*line).setMaxResults(page*line).list();
	}
}
