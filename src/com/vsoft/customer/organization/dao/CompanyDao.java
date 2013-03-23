package com.vsoft.customer.organization.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.vsoft.core.base.dao.BaseDao;

@Repository
public class CompanyDao extends BaseDao {

	private static final Logger LOG = Logger.getLogger(CompanyDao.class);

	public void addCompany(Map<String, Object> data) {
		try {
			this.insertToTable("com_customer_company", data);
			LOG.info("新增公司成功");
		} catch (SQLException e) {
			LOG.error("新增公司时出错", e);
			e.printStackTrace();
		}
	}

	public int addCompanyReturnId(Map<String, Object> data) {
		int id = 0;
		try {
			id = this.insertAndReturnPrimaryId("com_customer_company", data);
			LOG.info("新增公司成功， ID = " + id);
		} catch (SQLException e) {
			LOG.error("新增公司时出错", e);
			e.printStackTrace();
		}
		return id;
	}
}
