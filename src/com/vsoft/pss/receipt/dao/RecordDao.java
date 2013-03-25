package com.vsoft.pss.receipt.dao;

import java.sql.SQLException;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.vsoft.core.base.dao.BaseDao;

@Repository
public class RecordDao extends BaseDao {

	private static final Logger LOG = Logger.getLogger(RecordDao.class);

	public void addRecord(Map<String, Object> data) {
		try {
			this.insertToTable("com_pss_record", data);
			LOG.info("新增记录成功");
		} catch (SQLException e) {
			LOG.error("新增记录失败", e);
			e.printStackTrace();
		}
	}
}
