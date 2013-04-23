package com.vsoft.pss.inventory.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.vsoft.core.base.dao.BaseDao;

@Repository
public class SortDao extends BaseDao {

	private final static Logger LOG = Logger.getLogger(SortDao.class);

	/**
	 * 添加商品类别
	 * 
	 * @param data
	 * @return
	 */
	public boolean addSort(Map<String, Object> data) {
		try {
			this.insertToTable("com_pss_sort", data);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 更新商品类别
	 * 
	 * @param data
	 * @return
	 */
	public boolean updateSort(Map<String, Object> data) {
		try {
			this.updateTableById("com_pss_sort", data);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 分页查询商品类别
	 * 
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> querySort(List<Object> params) {
		List<Map<String, Object>> datas = null;
		String sql = "select s.id,s.name,s.parentId,s.parent,ts.name as parentname from com_pss_sort s left join com_pss_sort ts on s.parentId = ts.id order by s.parentId asc, s.id desc limit ? , ?";
		try {
			datas = this.executeQueryMultiple(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	/**
	 * 查询所有父级商品类别
	 * 
	 * @return
	 */
	public List<Map<String, Object>> querySort() {
		List<Map<String, Object>> datas = null;
		String sql = "select s.id,s.name from com_pss_sort s where s.parent = true order by s.parentId asc, s.id desc";
		try {
			datas = this.executeQueryMultiple(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
		
	}
	
	/**
	 * 删除商品类别
	 * 
	 * @param idStr
	 * @return
	 */
	public boolean deleteSort(String idStr) {
		StringBuffer sql = new StringBuffer("delete from com_pss_sort where id in (");
		sql.append(idStr).append(")");
		try {
			this.execute(sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public int countSort() {
		int count = 0;
		try {
			count = this.countTable("com_pss_sort", "id", null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
