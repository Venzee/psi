package com.vsoft.customer.organization.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.vsoft.core.base.dao.BaseDao;

@Repository
public class IndustryDao extends BaseDao {

	private static final Logger LOG = Logger.getLogger(IndustryDao.class);

	public boolean addIndustry(Map<String, Object> data) {
		try {
			this.insertToTable("com_customer_industry", data);
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
		String sql = "select t.id,t.name,t.description from com_customer_industry t";
		try {
			list = this.executeQueryWithMultiple(sql, params);
		} catch (SQLException e) {
			LOG.error("查询多个行业时出错", e);
			e.printStackTrace();
		}
		return list;
	}

}
