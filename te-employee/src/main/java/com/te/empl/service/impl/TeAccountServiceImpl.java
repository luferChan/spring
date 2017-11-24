package com.te.empl.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;





import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.te.empl.constant.SessionKey;
import com.te.empl.constant.db.TeAccountState;
import com.te.empl.constant.db.TeAccountType;
import com.te.empl.dao.TeAccountDao;
import com.te.empl.model.TeAccount;
import com.te.empl.service.TeAccountService;
import com.te.empl.support.JSONReturn;
import com.te.empl.utils.EncryptUtil;
import com.te.empl.utils.Logable;

@Service
@Transactional

public class TeAccountServiceImpl extends Logable implements TeAccountService {

	@Autowired
	private TeAccountDao teAccountDao;

	@Override
	public JSONReturn login(String username, String password,
			HttpServletRequest request) {
		info("{}正尝试登录系统，尝试密码为{}", username,password);
		// 判空条件
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
			error("\t登录失败，用户名密码为空");
			return JSONReturn.buildFailure("非法操作");
		}
		
		// 通过用户名到数据库中检测数据是否存在
		
		TeAccount teAccount = teAccountDao.findUniqueByProperty(teAccountDao.USERNAME, username);
		if(teAccount == null){
			//说明用户名不正确
			warning("\t登录失败，用户名{}不存在；",username);
			return JSONReturn.buildFailure("帐号或密码不正确！");
		}
		
		// 通过密码检测验证数据是否匹配
		if(!teAccount.getPassword().equals(EncryptUtil.md5(password)))
		{
			warning("\t登录失败，密码{}不匹配；",password);
			return JSONReturn.buildFailure("帐号或密码不正确！");
		}
		
		// 匹配成功将对象存到session中，并返回
		request.getSession().setAttribute(SessionKey.LOGIN_USER_INFO, teAccount);
		info("\t{}登录成功了",  username);
		return JSONReturn.buildSuccessWithEmptyBody();
	}
	


}
