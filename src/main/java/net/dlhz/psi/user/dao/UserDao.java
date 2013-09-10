package net.dlhz.psi.user.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.dlhz.core.base.dao.BaseDao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao {

	public int countByUsername(String username) {
		try {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("username", username);
			return this.countTable("psi_user", "username", data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Map<String, Object> queryUserForLogin(List<Object> params) {
		String sql = "select u.id userId,u.username,u.groupId,u.empId,u.comId,u.powers||g.powers,"
				+ "c.name companyName,c.expireDate,c.master,i.sorts,g.name groupName,e.name employeeName,e.birth employeeBirth,e.status,d.name departmentName "
				+ "from psi_user u " + "left join psi_base_company c on u.comId = c.id "
				+ "left join psi_base_industry i on c.indusId = i.id "
				+ "left join psi_user_group g on u.groupId = g.id "
				+ "left join psi_base_employee e on u.empId = e.id "
				+ "left join psi_base_department d on e.deptId = d.id "
				+ "where u.username = ? and u.password = ? and u.status = 0";
		try {
			return executeQuerySingle(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
