package com.vsoft.customer.organization.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vsoft.core.base.dao.BaseDao;

public class DepartmentDao extends BaseDao {
	private static final Logger LOG = Logger.getLogger(DepartmentDao.class);
	
	public void addDepartment(Map<String, Object> data) {
		try {
			this.insertToTable("com_customer_department", data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
