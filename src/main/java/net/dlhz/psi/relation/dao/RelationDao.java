package net.dlhz.psi.relation.dao;

import java.sql.SQLException;
import java.util.Map;

import net.dlhz.core.base.dao.BaseDao;
import net.dlhz.psi.relation.entity.Relation;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


@Repository
public class RelationDao extends BaseDao {

	private static final Logger LOG = Logger.getLogger(Relation.class);

	public void addContacts(Map<String, Object> data) {
		try {
			this.insertToTable("psi_relation", data);
			LOG.info("新增往来单位成功");
		} catch (SQLException e) {
			LOG.error("新增往来单位时出错", e);
			e.printStackTrace();
		}
	}
	
}
