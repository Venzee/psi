package com.vsoft.pss.sys.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.vsoft.core.base.dao.BaseDao;

@Repository
public class MenuDao extends BaseDao {

	private final static Logger LOG = Logger.getLogger(MenuDao.class);

	public void addMenu(Map<String, Object> data) {
		try {
			this.insertToTable("pss_menu", data);
			LOG.info("新增菜单时成功");
		} catch (SQLException e) {
			LOG.error("新增菜单时出错", e);
			e.printStackTrace();
		}
	}
	
	public List<Map<String, Object>> queryAllMenu(List<Object> params) {
		List<Map<String, Object>> list = null;
		String sql = "select t.id,t.name,t.url,t.right,t.parentId,t.parent from pss_menu t";
		try {
			list = this.executeQueryMultiple(sql, params);
		} catch (SQLException e) {
			LOG.error("查询多个菜单时出错", e);
			e.printStackTrace();
		}
		return list;
	}
}
