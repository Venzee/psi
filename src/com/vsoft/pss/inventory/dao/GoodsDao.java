package com.vsoft.pss.inventory.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.vsoft.core.base.dao.BaseDao;

@Repository
public class GoodsDao extends BaseDao {
	private final static Logger LOG = Logger.getLogger(GoodsDao.class);
	
	public boolean addGoods(Map<String, Object> data) {
		try {
			this.insertToTable("com_pss_goods", data);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateGoodsById(Map<String, Object> data) {
		try {
			this.updateTableById("com_pss_goods", data);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Map<String, Object>> queryAllGoods(List<Object> params) {
		List<Map<String, Object>> datas = null;
		String sql = "select * from com_pss_goods s order by s.id desc limit ? , ?";
		try {
			datas = this.executeQueryWithMultiple(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	public Map<String, Object> queryOneGoods(List<Object> params) {
		Map<String, Object> data = null;
		String sql = "select * from com_pss_goods s where s.id = ?";
		try {
			data = this.executeQueryWithSingle(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public boolean deleteGoods(String id) {
		StringBuffer sql = new StringBuffer("delete from com_pss_goods where id in (");
		sql.append(id).append(")");
		try {
			this.execute(sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public int countGoodsById() {
		int count = 0;
		try {
			count = this.countTable("com_pss_goods", "id", null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
