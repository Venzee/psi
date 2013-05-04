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
			this.insertToTable("pss_brand", data);
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
			this.updateTableById("pss_brand", data);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Map<String, Object>> queryAllBrand(List<Object> params) {
		List<Map<String, Object>> datas = null;
		String sql = "select b.id,b.name,b.englishName,b.logo,b.remark,b.status,b.createDate,i.name as sortname from pss_brand b left join pss_sort i on i.id = b.sortId order by b.id desc limit ? , ?";
		try {
			datas = this.executeQueryMultiple(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}

	public List<Map<String, Object>> queryBrandByIndustry(List<Object> params) {
		List<Map<String, Object>> datas = null;
		String sql = "select b.id,b.name from pss_brand b where b.industryId = ? or b.createCompanyId = ? order by b.id desc";
		try {
			datas = this.executeQueryMultiple(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
	}

	public Map<String, Object> queryOneBrand(List<Object> params) {
		Map<String, Object> data = null;
		String sql = "select * from pss_brand s where s.id = ?";
		try {
			data = this.executeQuerySingle(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	public boolean deleteBrand(String idStr) {
		StringBuffer sql = new StringBuffer("delete from pss_brand where id in (");
		sql.append(idStr).append(")");
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
			count = this.countTable("pss_brand", "id", null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
