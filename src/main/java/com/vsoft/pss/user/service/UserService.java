package com.vsoft.pss.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsoft.core.base.entity.SessionUser;
import com.vsoft.core.util.DataUtil;
import com.vsoft.pss.user.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public SessionUser login(String username, String password) {
		List<Object> params = new ArrayList<Object>();
		SessionUser sessionUser = new SessionUser();
		params.add(username);
		params.add(password);
		Map<String, Object> data = userDao.queryUserForLogin(params);
		if(null != data){
			sessionUser = (SessionUser) DataUtil.parseMapToObject(data, SessionUser.class);
		}
		return sessionUser;
	}
}
