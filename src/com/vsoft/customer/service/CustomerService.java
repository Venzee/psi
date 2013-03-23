package com.vsoft.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsoft.core.util.DataUtil;
import com.vsoft.customer.organization.dao.CompanyDao;
import com.vsoft.customer.organization.dao.OrganizationDao;
import com.vsoft.customer.organization.entity.Company;
import com.vsoft.customer.organization.entity.Organization;
import com.vsoft.customer.user.dao.UserDao;
import com.vsoft.customer.user.entity.User;

@Service
public class CustomerService {

	@Autowired
	private OrganizationDao organizationDao;
	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private UserDao userDao;

	public User register(Organization organization, Company company, User user) {
		Map<String, Object> organizationData = DataUtil.parseObjectToMap(organization, Organization.class);
		int organizationId = organizationDao.addOrganizationReturnId(organizationData);
		company.setOrganizationId(organizationId);
		Map<String, Object> companyData = DataUtil.parseObjectToMap(company, Company.class);
		int companyId = companyDao.addCompanyReturnId(companyData);
		user.setCompanyId(companyId);
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
