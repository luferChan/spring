package com.te.empl.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.te.empl.constant.db.TeDepartmentState;
import com.te.empl.dao.support.AbstractDao;
import com.te.empl.model.TeDepartment;
import com.te.empl.utils.QueryUtil;

@Repository
public class TeDepartmentDao extends AbstractDao<TeDepartment> implements Serializable{
	
	
	private static final long serialVersionUID = 8956575292104244432L;
	String query = "";
	@Override
	public Class<TeDepartment> getEntityClass() {
		// TODO Auto-generated method stub
		return TeDepartment.class;
	}

	@SuppressWarnings("unchecked")
	public List<TeDepartment> findDepartmentList(String search_name, int page,
			int line) {
		
		if(StringUtils.isEmpty(search_name)){
			query = "from TeDepartment where state = ? order by id desc ";
			return findSession().createQuery(query).setInteger(0, TeDepartmentState.normal.getState()).setFirstResult((page-1)*line).setMaxResults(page*line).list();
		}

		// 模糊查询 from TeDepartment where name like '%xxx%' limit 0,15
		query = "from TeDepartment where name like ? and state = ? order by id desc";
		return findSession().createQuery(query).setString(0, QueryUtil.packLink(search_name)).setInteger(1, TeDepartmentState.normal.getState())
				.setFirstResult((page-1)*line).setMaxResults(page*line).list();
	}

	public int findDepartmentPage(String search_name) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(search_name)){
			query = "select count(id) from TeDepartment where state = ?";
			return Integer.parseInt(findSession().createQuery(query).setInteger(0, TeDepartmentState.normal.getState()).uniqueResult().toString());
		}
		query = "select count(id) from TeDepartment where name like ? and state = ?";
		
		return Integer.parseInt(findSession().createQuery(query).setString(0, QueryUtil.packLink(search_name)).setInteger(1, TeDepartmentState.normal.getState()).uniqueResult().toString());
	}
}
