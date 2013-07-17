package com.vsoft.pss.inventory.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.vsoft.core.base.dao.BaseDao;

@Repository
public class InventoryDao extends BaseDao {
	private final static Logger LOG = Logger.getLogger(InventoryDao.class);

	public boolean addInventory(Map<String, Object> data) {
		try {
			this.insertToTable("pss_inventory", data);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Map<String, Object>> queryAllInventory(List<Object> params) {
		List<Map<String, Object>> datas = null;
		String sql = "pss_inventory";
		try {
			datas = this.executeQueryMultiple(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
}
