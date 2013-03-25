package com.vsoft.pss.sys.dao;

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
			this.insertToTable("com_pss_menu", data);
			LOG.info("新增菜单时成功");
		} catch (SQLException e) {
			LOG.error("新增菜单时出错", e);
			e.printStackTrace();
		}
	}
}
