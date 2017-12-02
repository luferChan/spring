package com.te.empl.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.te.empl.dao.support.AbstractDao;
import com.te.empl.model.TeDepartment;
import com.te.empl.utils.QueryUtil;

@Repository
public class TeDepartmentDao extends AbstractDao<TeDepartment> implements Serializable{
	
	/**
	 * 
	 */
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
			query = "from TeDepartment order by id desc";
			return findSession().createQuery(query).setFirstResult((page-1)*line).setMaxResults(page*line).list();
		}

		// 模糊查询 from TeDepartment where name like '%xxx%' limit 0,15
		query = "from TeDepartment where name like ? order by id desc";
		return findSession().createQuery(query).setString(0, QueryUtil.packLink(search_name))
				.setFirstResult((page-1)*line).setMaxResults(page*line).list();
	}

	public int findDepartmentPage(String search_name) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(search_name)){
			query = "select count(id) from TeDepartment";
			return Integer.parseInt(findSession().createQuery(query).uniqueResult().toString());
		}
		query = "select count(id) from TeDepartment where name like ? ";
		
		return Integer.parseInt(findSession().createQuery(query).setString(0, QueryUtil.packLink(search_name)).uniqueResult().toString());
	}
}
