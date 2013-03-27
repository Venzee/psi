package com.vsoft.pss.inventory.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.vsoft.core.base.dao.BaseDao;

@Repository
public class SortDao extends BaseDao {

	private final static Logger LOG = Logger.getLogger(SortDao.class);
	
	public void addSort(Map<String, Object> data) {
		try {
			this.insertToTable("com_pss_sort", data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Map<String, Object>> queryAllSort(List<Object> params) {
		String sql = "select s.id,s.name,s.remark,s.topId,s.level from com_pss_sort s";
		try {
			this.executeQueryWithMultiple(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
