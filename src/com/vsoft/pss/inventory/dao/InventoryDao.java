package com.vsoft.pss.inventory.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vsoft.core.base.dao.BaseDao;

public class InventoryDao extends BaseDao {
	private final static Logger LOG = Logger.getLogger(InventoryDao.class);

	public boolean addInventory(Map<String, Object> data) {
		try {
			this.insertToTable("com_pss_inventory", data);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Map<String, Object>> queryAllInventory(List<Object> params) {
		List<Map<String, Object>> datas = null;
		String sql = "com_pss_inventory";
		try {
			datas = this.executeQueryWithMultiple(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
}
