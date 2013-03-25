package com.vsoft.pss.inventory.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vsoft.core.base.dao.BaseDao;

public class GoodsDao extends BaseDao {
	private final static Logger LOG = Logger.getLogger(GoodsDao.class);
	
	public void addGoods(Map<String, Object> data) {
		try {
			this.insertToTable("com_pss_goods", data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
