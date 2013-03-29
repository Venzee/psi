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
	
	public void updateTableById(Map<String, Object> data) {
		try {
			this.updateTableById("com_pss_sort", data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Map<String, Object>> queryAllSort(List<Object> params) {
		List<Map<String, Object>> datas = null;
		String sql = "select s.id,s.name,s.remark,s.topId,s.level,ts.name as topname from com_pss_sort s left join com_pss_sort ts on ts.id = ? limit ? , ?";
		try {
			datas = this.executeQueryWithMultiple(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	
	public int countSortById() {
		int count = 0;
		try {
			count = this.countTable("com_pss_sort", "id", null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
