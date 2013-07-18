package com.vsoft.pss.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsoft.core.util.DataUtil;
import com.vsoft.pss.organization.dao.CompanyDao;
import com.vsoft.pss.organization.dao.OrganizationDao;
import com.vsoft.pss.user.dao.UserDao;
import com.vsoft.pss.user.entity.User;

@Service
public class UserService {

	@Autowired
	private OrganizationDao organizationDao;
	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private UserDao userDao;

	public User register(User user) {
		Map<String, Object> userData = DataUtil.parseObjectToMap(user, User.class);
		int userId = userDao.addUserReturnId(userData);
		user.setId(userId);
		return user;
	}
	
	public User login(User user) {
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUsername());
		params.add(user.getPassword());
		Map<String, Object> data = userDao.queryUserForLogin(params);
		if(null != data){
			user = (User) DataUtil.parseMapToObject(data, User.class);
		}
		return user;
	}
}
