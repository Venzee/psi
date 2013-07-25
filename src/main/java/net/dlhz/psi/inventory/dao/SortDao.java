package net.dlhz.psi.inventory.dao;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import net.dlhz.core.base.dao.BaseDao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


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
			this.insertToTable("psi_goods_sort", data);
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
			int id = this.insertAndReturnPrimaryId("psi_goods_sort", data);
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
			this.updateSourceById("psi_goods_sort", data);
		} catch (SQLException e) {
			LOG.error("更新商品类目时出错", e);
			return false;
		}
		return true;
	}

	/**
	 * 查询类别
	 * 
	 * @param parentId
	 * @return
	 */
	public List<Map<String, Object>> querySort(Object parentId) {
		List<Map<String, Object>> datas = null;
		String sql = "select s.id,s.name,s.parentId from psi_goods_sort s where s.parentId = ? order by s.parentId asc, s.id desc";
		try {
			datas = this.executeQueryMultiple(sql, Arrays.asList(parentId));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	/**
	 * 根据ID查询类目
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> querySortById(Object id) {
		Map<String, Object> data = null;
		String sql = "select s.id,s.name,s.parentId from psi_goods_sort s where s.id = ?";
		try {
			data = this.executeQuerySingle(sql, Arrays.asList(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * 按条件统计记录数
	 * 
	 * @param data
	 * @return
	 */
	public int countSort(Map<String, Object> data) {
		int count = 0;
		try {
			count = this.countTable("psi_goods_sort", "id", data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 删除商品类别
	 * 
	 * @param idStr
	 * @return
	 */
	public boolean deleteSort(String idStr) {
		StringBuffer sql = new StringBuffer("delete from psi_goods_sort where id in (");
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
