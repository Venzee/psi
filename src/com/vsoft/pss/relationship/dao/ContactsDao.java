package com.vsoft.pss.relationship.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.vsoft.core.base.dao.BaseDao;
import com.vsoft.pss.relationship.entity.Contacts;

@Repository
public class ContactsDao extends BaseDao {

	private static final Logger LOG = Logger.getLogger(Contacts.class);

	public void addContacts(Map<String, Object> data) {
		try {
			this.insertToTable("com_pss_contacts", data);
			LOG.info("新增往来单位成功");
		} catch (SQLException e) {
			LOG.error("新增往来单位时出错", e);
			e.printStackTrace();
		}
	}
	
}
