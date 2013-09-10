package net.dlhz.psi.goods.dao;

import java.sql.SQLException;
import java.util.Map;

import net.dlhz.core.base.dao.BaseDao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


@Repository
public class WarehouseDao extends BaseDao {

	private final static Logger LOG = Logger.getLogger(WarehouseDao.class);

	public boolean addWarehouse(Map<String, Object> data) {
		try {
			this.insertToTable("psi_warehouse", data);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
