package com.te.empl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.te.empl.dao.support.AbstractDao;
import com.te.empl.model.TeAccount;



@Repository
public class TeAccountDao extends AbstractDao<TeAccount>{
	
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String STATE = "state";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String NICKNAME = "nickname";
	public static final String CREATOR = "creator";
	
	
	@Override
	public Class<TeAccount> getEntityClass() {
		//返回数据表对应的class
		return TeAccount.class;
	}
	


	

	
}
