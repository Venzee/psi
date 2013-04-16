package com.vsoft.pss.user.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.vsoft.core.base.dao.BaseDao;

@Repository
public class UserDao extends BaseDao {

	private static final Logger LOG = Logger.getLogger(UserDao.class);

	public void addUser(Map<String, Object> data) {
		try {
			this.insertToTable("com_customer_user", data);
			LOG.info("用户注册成功");
		} catch (SQLException e) {
			LOG.info("用户注册时出错", e);
			e.printStackTrace();
		}
	}

	public int addUserReturnId(Map<String, Object> data) {
		int id = 0;
		try {
			id = this.insertAndReturnPrimaryId("com_customer_user", data);
			LOG.info("用户注册成功");
		} catch (SQLException e) {
			LOG.info("用户注册时出错", e);
			e.printStackTrace();
		}
		return id;
	}
	
	public Map<String, Object> queryUserForLogin(List<Object> params) {
		String sql = "select u.id,u.username,u.password,u.groupId,u.employeeId,u.companyId from com_customer_user u where u.username = ? and u.password = ?";
		try {
			return this.executeQueryWithSingle(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
