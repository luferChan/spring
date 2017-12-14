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
	public List<TePosition> getPositionList(Long departmentId,String search_name, int page,
			int line) {
		StringBuffer query = new StringBuffer();
		query.append("from TePosition where state = ? ");
		// 判断查询条件前是否有选择部门
		if(departmentId != -1){
			query.append("and department = ? ");
			if(StringUtils.isEmpty(search_name)){
				
				query.append(" order by id desc");
				return findSession().createQuery(query.toString()).setInteger(0, TePositionState.normal.getState())
						.setLong(1, departmentId).setFirstResult((page-1)*line).setMaxResults(page*line).list();
			}
			query.append("and name like ? order by id desc"); 
			return findSession().createQuery(query.toString()).setInteger(0, TePositionState.normal.getState())
					.setLong(1, departmentId).setString(2, QueryUtil.packLink(search_name)).setFirstResult((page-1)*line).setMaxResults(page*line).list();
		}
		
		if(StringUtils.isEmpty(search_name)){
			
			query.append(" order by id desc");
			return findSession().createQuery(query.toString()).setInteger(0, TePositionState.normal.getState())
					.setFirstResult((page-1)*line).setMaxResults(page*line).list();
		}
		
		query.append("and name like ? order by id desc"); 
		return findSession().createQuery(query.toString()).setInteger(0, TePositionState.normal.getState())
				.setString(1, QueryUtil.packLink(search_name)).setFirstResult((page-1)*line).setMaxResults(page*line).list();
	}
	
	public int getPositionPage(Long departmentId, String search_name) {
		// TODO Auto-generated method stub
		StringBuffer query = new StringBuffer();
		query.append("select count(*) from TePosition where state = ? ");
		// 判断查询条件前是否有选择部门
		if(departmentId != -1){
			query.append("and department = ? ");
			if(StringUtils.isEmpty(search_name)){	
				return Integer.parseInt(findSession().createQuery(query.toString()).setInteger(0, TePositionState.normal.getState())
						.setLong(1, departmentId).uniqueResult().toString());
			}
			query.append("and name like ? "); 
			return Integer.parseInt(findSession().createQuery(query.toString()).setInteger(0, TePositionState.normal.getState())
					.setLong(1, departmentId).setString(2, QueryUtil.packLink(search_name)).uniqueResult().toString());
		}
		
		if(StringUtils.isEmpty(search_name)){
			return Integer.parseInt(findSession().createQuery(query.toString()).setInteger(0, TePositionState.normal.getState())
					.uniqueResult().toString());
		}
		
		query.append("and name like ? "); 
		return Integer.parseInt(findSession().createQuery(query.toString()).setInteger(0, TePositionState.normal.getState())
				.setString(1, QueryUtil.packLink(search_name)).uniqueResult().toString());
	}
	
	
	
}
