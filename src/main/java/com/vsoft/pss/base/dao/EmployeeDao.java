package com.vsoft.pss.base.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vsoft.core.base.dao.BaseDao;

public class EmployeeDao extends BaseDao {
	private static final Logger LOG = Logger.getLogger(EmployeeDao.class);

	public void addEmployee(Map<String, Object> data) {
		try {
			this.insertToTable("pss_employee", data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
