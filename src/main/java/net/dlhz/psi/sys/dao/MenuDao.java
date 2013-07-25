package net.dlhz.psi.sys.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import net.dlhz.core.base.dao.BaseDao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


@Repository
public class MenuDao extends BaseDao {

	private final static Logger LOG = Logger.getLogger(MenuDao.class);

	public boolean addMenu(Map<String, Object> data) {
		try {
			this.insertToTable("psi_menu", data);
			LOG.info("新增菜单时成功");
			return true;
		} catch (SQLException e) {
			LOG.error("新增菜单时出错", e);
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Map<String, Object>> queryAllMenu() {
		List<Map<String, Object>> list = null;
		String sql = "select t.id,t.name,t.url,t.power,t.parentId,t.parent from psi_menu t";
		try {
			list = this.executeQueryMultiple(sql);
		} catch (SQLException e) {
			LOG.error("查询多个菜单时出错", e);
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteMenu(String idStr) {
		StringBuffer sql = new StringBuffer("delete from psi_menu where id in (");
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
