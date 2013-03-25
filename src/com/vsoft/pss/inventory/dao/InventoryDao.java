package com.vsoft.pss.inventory.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vsoft.core.base.dao.BaseDao;

public class InventoryDao extends BaseDao {
	private final static Logger LOG = Logger.getLogger(InventoryDao.class);
	
	public void addInventory(Map<String, Object> data) {
		try {
			this.insertToTable("com_pss_inventory", data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
