package com.vsoft.pss.inventory.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.vsoft.core.base.dao.BaseDao;

@Repository
public class BrandDao extends BaseDao {

	private final static Logger LOG = Logger.getLogger(BrandDao.class);

	public boolean addBrand(Map<String, Object> data) {
		try {
			this.insertToTable("com_pss_brand", data);
			LOG.info("新增品牌成功");
			return true;
		} catch (SQLException e) {
			LOG.error("新增品牌时出错", e);
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateBrandById(Map<String, Object> data) {
		try {
			this.updateTableById("com_pss_brand", data);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Map<String, Object>> queryAllBrand(List<Object> params) {
		List<Map<String, Object>> datas = null;
		String sql = "select b.*,i.name as industryname from com_pss_brand b left join com_pss_industry i on i.id = b.industryid order by b.id desc limit ? , ?";
		try {
			datas = this.executeQueryWithMultiple(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}

	public List<Map<String, Object>> queryBrandByIndustry(List<Object> params) {
		List<Map<String, Object>> datas = null;
		String sql = "select b.id,b.name from com_pss_brand b where b.industryId = ? or b.createCompanyId = ? order by b.id desc";
		try {
			datas = this.executeQueryWithMultiple(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}

	public Map<String, Object> queryOneBrand(List<Object> params) {
		Map<String, Object> data = null;
		String sql = "select * from com_pss_brand s where s.id = ?";
		try {
			data = this.executeQueryWithSingle(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	public boolean deleteBrand(String id) {
		StringBuffer sql = new StringBuffer("delete from com_pss_brand where id in (");
		sql.append(id).append(")");
		try {
			this.execute(sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public int countBrandById() {
		int count = 0;
		try {
			count = this.countTable("com_pss_brand", "id", null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
