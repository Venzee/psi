package net.dlhz.psi.base.dao;

import java.sql.SQLException;
import java.util.Map;

import net.dlhz.core.base.dao.BaseDao;

import org.apache.log4j.Logger;


public class DepartmentDao extends BaseDao {
	private static final Logger LOG = Logger.getLogger(DepartmentDao.class);
	
	public void addDepartment(Map<String, Object> data) {
		try {
			this.insertToTable("psi_department", data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
