package com.dlhz.pss.user.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.dlhz.core.base.dao.BaseDao;

public class UserGroupDao extends BaseDao {
	private static final Logger LOG = Logger.getLogger(UserGroupDao.class);

	public void addUserGroup(Map<String, Object> data) {
		try {
			this.insertToTable("pss_usergroup", data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
