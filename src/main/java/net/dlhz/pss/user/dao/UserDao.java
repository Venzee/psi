package net.dlhz.pss.user.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import net.dlhz.core.base.dao.BaseDao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao extends BaseDao {

	private static final Logger LOG = Logger.getLogger(UserDao.class);

	public Map<String, Object> queryUserForLogin(List<Object> params) {
		String sql = "select u.id userId,u.username,u.groupId,u.employeeId,u.companyId,u.powers||g.powers," +
				"c.name companyName,c.expireDate,c.master,i.sorts,g.name groupName,e.name employeeName,e.birth employeeBirth,e.status,d.name departmentName " +
				"from pss_user u " +
				"left join pss_company c on u.companyId = c.id " +
				"left join pss_industry i on c.industryId = i.id " +
				"left join pss_user_group g on u.groupId = g.id " +
				"left join pss_employee e on u.employeeId = e.id " +
				"left join pss_department d on e.departmentId = d.id " +
				"where u.username = ? and u.password = ? and u.status = 0";
		try {
			return executeQuerySingle(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
