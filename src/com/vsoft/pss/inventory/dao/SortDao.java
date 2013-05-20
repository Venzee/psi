package com.vsoft.pss.inventory.dao;

import java.sql.SQLException;
import java.util.Arrays;
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
			this.insertToTable("pss_sort", data);
		} catch (SQLException e) {
			LOG.error("添加商品类目时出错", e);
			return false;
		}
		return true;
	}
	
	/**
	 * 添加商品类别并返回
	 * 
	 * @param data
	 * @return
	 */
	public Map<String, Object> addSortAndReturn(Map<String, Object> data) {
		try {
			int id = this.insertAndReturnPrimaryId("pss_sort", data);
			data.put("id", id);
			LOG.debug("添加商品类目成功！ ID = " + id);
		} catch (SQLException e) {
			LOG.error("添加商品类目时出错", e);
		}
		return data;
	}

	/**
	 * 更新商品类别
	 * 
	 * @param data
	 * @return
	 */
	public boolean updateSort(Map<String, Object> data) {
		try {
			this.updateTableById("pss_sort", data);
		} catch (SQLException e) {
			LOG.error("更新商品类目时出错", e);
			return false;
		}
		return true;
	}

	/**
	 * 查询对应父级商品类别的所有子类别
	 * 
	 * @param parentId
	 * @return
	 */
	public List<Map<String, Object>> querySort(Object parentId) {
		List<Map<String, Object>> datas = null;
		String sql = "select s.id,s.name,s.code,s.parentId,s.primary from pss_sort s where s.parentId = ? order by s.parentId asc, s.id desc";
		try {
			datas = this.executeQueryMultiple(sql, Arrays.asList(parentId));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	/**
	 * 查询初级商品类别
	 * 
	 * @return
	 */
	public List<Map<String, Object>> querySort() {
		List<Map<String, Object>> datas = null;
		String sql = "select s.id,s.name,s.code,s.parentId,s.primary from pss_sort s where s.primary = true";
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
		StringBuffer sql = new StringBuffer("delete from pss_sort where id in (");
		sql.append(idStr).append(")");
		try {
			this.execute(sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
