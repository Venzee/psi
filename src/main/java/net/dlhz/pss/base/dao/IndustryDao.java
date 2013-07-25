package net.dlhz.pss.base.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import net.dlhz.core.base.dao.BaseDao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


@Repository
public class IndustryDao extends BaseDao {

	private static final Logger LOG = Logger.getLogger(IndustryDao.class);

	public boolean addIndustry(Map<String, Object> data) {
		try {
			this.insertToTable("pss_industry", data);
			LOG.info("新增行业成功");
			return true;
		} catch (SQLException e) {
			LOG.error("新增行业时出错", e);
			e.printStackTrace();
			return false;
		}
	}

	public List<Map<String, Object>> queryAllIndustry(List<Object> params) {
		List<Map<String, Object>> list = null;
		String sql = "select t.id,t.name,t.description from pss_industry t";
		try {
			list = this.executeQueryMultiple(sql, params);
		} catch (SQLException e) {
			LOG.error("查询多个行业时出错", e);
			e.printStackTrace();
		}
		return list;
	}

	public List<Map<String, Object>> queryAllIndustryWithoutDescription(List<Object> params) {
		List<Map<String, Object>> list = null;
		String sql = "select t.id,t.name from pss_industry t";
		try {
			list = this.executeQueryMultiple(sql, params);
		} catch (SQLException e) {
			LOG.error("查询多个行业时出错", e);
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteIndustry(String idStr) {
		StringBuffer sql = new StringBuffer("delete from pss_industry where id in (");
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
