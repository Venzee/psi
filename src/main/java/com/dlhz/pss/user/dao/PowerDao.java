package com.dlhz.pss.user.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.dlhz.core.base.dao.BaseDao;

public class PowerDao extends BaseDao {
	private static final Logger LOG = Logger.getLogger(PowerDao.class);

	public void addRight(Map<String, Object> data) {
		try {
			this.insertToTable("pss_power", data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
