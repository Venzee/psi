/*-------------------------------------------------
 * Project:　　  test
 * FileName:    MenuDao.java
 * PackageName: com.vsoft.jxc.sys.dao
 * Company:     Sentree
 * Copyright:   ©2013 Sentree Co.
 * Version:     1.0
 * History:     Mar 18, 2013 1:09:41 PM (zw) Create
 *------------------------------------------------*/

package com.vsoft.jxc.sys.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.vsoft.core.base.dao.BaseDao;

@Repository
public class MenuDao extends BaseDao {

	private final static Logger LOG = Logger.getLogger(MenuDao.class);

	public void addMenu(Map<String, Object> data) {
		try {
			this.insertToTable("sys_menu", data);
			LOG.info("新增菜单时成功");
		} catch (SQLException e) {
			LOG.error("新增菜单时出错", e);
			e.printStackTrace();
		}
	}
}
