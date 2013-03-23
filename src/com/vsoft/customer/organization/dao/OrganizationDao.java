package com.vsoft.customer.organization.dao;

import java.sql.SQLException;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.vsoft.core.base.dao.BaseDao;

@Repository
public class OrganizationDao extends BaseDao {

	private static final Logger LOG = Logger.getLogger(OrganizationDao.class);

	public void addOrganization(Map<String, Object> data) {
		try {
			this.insertToTable("com_customer_organization", data);
			LOG.info("新增机构成功");
		} catch (SQLException e) {
			LOG.error("新增机构时出错", e);
			e.printStackTrace();
		}
	}

	public int addOrganizationReturnId(Map<String, Object> data) {
		int id = 0;
		try {
			id = this.insertAndReturnPrimaryId("com_customer_organization", data);
			LOG.info("新增机构成功，ID = " + id);
		} catch (SQLException e) {
			LOG.error("新增机构时出错", e);
			e.printStackTrace();
		}
		return id;
	}
}
