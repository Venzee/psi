package com.vsoft.customer.user.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vsoft.core.base.dao.BaseDao;

public class RightDao extends BaseDao {
	private static final Logger LOG = Logger.getLogger(RightDao.class);

	public void addRight(Map<String, Object> data) {
		try {
			this.insertToTable("com_customer_right", data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
