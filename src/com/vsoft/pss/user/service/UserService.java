package com.vsoft.pss.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsoft.core.util.DataUtil;
import com.vsoft.pss.organization.dao.CompanyDao;
import com.vsoft.pss.organization.dao.OrganizationDao;
import com.vsoft.pss.organization.entity.Company;
import com.vsoft.pss.organization.entity.Organization;
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

	public User register(Organization organization, Company company, User user) {
		organization.setJoinDate(new Date());
		organization.setExpireDate(new Date());
		Map<String, Object> organizationData = DataUtil.parseObjectToMap(organization, Organization.class);
		int organizationId = organizationDao.addOrganizationReturnId(organizationData);
		company.setOrganizationId(organizationId);
		Map<String, Object> companyData = DataUtil.parseObjectToMap(company, Company.class);
		int companyId = companyDao.addCompanyReturnId(companyData);
		user.setCompanyId(companyId);
		user.setCreateDate(new Date());
		return register(user);
	}

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
		user = (User) DataUtil.parseMapToObject(data, User.class);
		return user;
	}
}
