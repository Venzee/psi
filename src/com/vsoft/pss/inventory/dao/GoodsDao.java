package com.vsoft.pss.inventory.dao;

import java.sql.SQLException;
import java.util.Arrays;
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
			this.insertToTable("pss_goods", data);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateGoodsById(Map<String, Object> data) {
		try {
			this.updateSourceById("pss_goods", data);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Map<String, Object>> queryAllGoods(List<Object> params) {
		List<Map<String, Object>> datas = null;
		String sql = "select * from pss_goods s order by s.id desc limit ? , ?";
		try {
			datas = this.executeQueryMultiple(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	public Map<String, Object> queryOneGoods(List<Object> params) {
		Map<String, Object> data = null;
		String sql = "select * from pss_goods s where s.id = ?";
		try {
			data = this.executeQuerySingle(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * 根据类目ID查询正常状态商品
	 * 
	 * @param sortId
	 * @return
	 */
	public List<Map<String, Object>> queryGoodsBySort(Object sortId) {
		List<Map<String, Object>> datas = null;
		String sql = "select b.id,b.name,b.englishName,b.sortId,b.code from pss_goods b where b.sortId = ? and b.status = 0 order by b.id desc";
		try {
			datas = this.executeQueryMultiple(sql, Arrays.asList(sortId));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	/**
	 * 根据品牌ID查询正常状态商品
	 * 
	 * @param brandId
	 * @return
	 */
	public List<Map<String, Object>> queryGoodsByBrand(Object brandId) {
		List<Map<String, Object>> datas = null;
		String sql = "select b.id,b.name,b.englishName,b.brandId,b.sortId,b.code from pss_goods b where b.brandId = ? and b.status = 0 order by b.id desc";
		try {
			datas = this.executeQueryMultiple(sql, Arrays.asList(brandId));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	public boolean deleteGoods(String idStr) {
		StringBuffer sql = new StringBuffer("delete from pss_goods where id in (");
		sql.append(idStr).append(")");
		try {
			this.execute(sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 按条件统计记录数
	 * 
	 * @param data
	 * @return
	 */
	public int countGoods(Map<String, Object> data) {
		int count = 0;
		try {
			count = this.countTable("pss_goods", "id", data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
