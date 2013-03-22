/*-------------------------------------------------
 * Project:　　  test
 * FileName:    BrandDao.java
 * PackageName: com.vsoft.jxc.basic.dao
 * Company:     Sentree
 * Copyright:   ©2013 Sentree Co.
 * Version:     1.0
 * History:     Mar 18, 2013 4:13:27 PM (zw) Create
 *------------------------------------------------*/

package com.vsoft.jxc.inventory.dao;

import java.sql.SQLException;
import java.util.Map;
import org.apache.log4j.Logger;
import com.vsoft.core.base.dao.BaseDao;

public class BrandDao extends BaseDao {

	private final static Logger LOG = Logger.getLogger(BrandDao.class);

	public void addBrand(Map<String, Object> data) {
		try {
			this.insertToTable("basic_brand", data);
			LOG.info("新增品牌成功");
		} catch (SQLException e) {
			LOG.error("新增品牌时出错", e);
			e.printStackTrace();
		}
	}

}
