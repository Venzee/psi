package com.vsoft.pss.inventory.dao;

import java.sql.SQLException;
import java.util.Map;
import org.apache.log4j.Logger;
import com.vsoft.core.base.dao.BaseDao;

public class BrandDao extends BaseDao {

	private final static Logger LOG = Logger.getLogger(BrandDao.class);

	public void addBrand(Map<String, Object> data) {
		try {
			this.insertToTable("com_pss_brand", data);
			LOG.info("新增品牌成功");
		} catch (SQLException e) {
			LOG.error("新增品牌时出错", e);
			e.printStackTrace();
		}
	}

}
