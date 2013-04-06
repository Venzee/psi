package com.vsoft.pss.inventory.dao;

import java.sql.SQLException;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.vsoft.core.base.dao.BaseDao;

@Repository
public class WarehouseDao extends BaseDao {

	private final static Logger LOG = Logger.getLogger(WarehouseDao.class);

	public boolean addWarehouse(Map<String, Object> data) {
		try {
			this.insertToTable("com_pss_warehouse", data);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
