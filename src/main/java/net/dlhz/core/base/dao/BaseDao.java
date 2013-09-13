package net.dlhz.core.base.dao;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import net.dlhz.core.base.entity.Page;
import net.dlhz.core.util.DataUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.alibaba.druid.pool.DruidDataSource;

@Repository
public class BaseDao extends JdbcDaoSupport {

	private static final Logger LOG = Logger.getLogger(BaseDao.class);

	@Autowired
	private DruidDataSource dataSource;

	@Resource(name = "dataSource")
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	/**
	 * 批量执行
	 * 
	 * @param sql
	 * @param paramList
	 * @return
	 * @throws SQLException
	 */
	public int[] executeBatch(String sql, Collection<List<Object>> paramList) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		int updateCounts[];
		try {
			stmt = conn.prepareStatement(sql);
			for (List<Object> params : paramList) {
				setParamValues(stmt, params);
				stmt.addBatch();
			}
			updateCounts = stmt.executeBatch();
		} finally {
			close(stmt);
			close(conn);
		}
		return updateCounts;
	}

	/**
	 * 批量执行
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public int[] executeBatch(String sql, List<Object> params) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		int updateCounts[];
		try {
			stmt = conn.prepareStatement(sql);
			for (Object param : params) {
				stmt.setObject(1, param);
				stmt.addBatch();
			}
			updateCounts = stmt.executeBatch();
		} finally {
			close(stmt);
			close(conn);
		}
		return updateCounts;
	}

	/**
	 * 执行SQL
	 * 
	 * @param sql
	 * @throws SQLException
	 */
	public void execute(String sql) throws SQLException {
		this.getJdbcTemplate().execute(sql);
		/*Connection conn = getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.execute();
		} finally {
			close(stmt);
			close(conn);
		}*/
	}

	/**
	 * 执行SQL
	 * 
	 * @param sql
	 * @param params
	 * @throws SQLException
	 */
	public void execute(String sql, List<Object> params) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			if (params != null) {
				setParamValues(stmt, params);
			}
			stmt.executeUpdate();
		} finally {
			close(stmt);
			close(conn);
		}
	}

	/**
	 * 更新数据
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public int executeUpdate(String sql, List<Object> params) throws SQLException {
		return this.getJdbcTemplate().update(sql, params.toArray());
		/*Connection conn = getConnection();
		PreparedStatement stmt = null;
		int updateCount;
		try {
			stmt = conn.prepareStatement(sql);
			setParamValues(stmt, params);
			updateCount = stmt.executeUpdate();
		} finally {
			close(stmt);
			close(conn);
		}
		return updateCount;*/
	}

	/**
	 * 查询单个结果
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> executeQuerySingle(String sql, List<Object> params) throws SQLException {
		return this.getJdbcTemplate().queryForMap(sql, params.toArray());
		/*Connection conn = getConnection();
		Map<String, Object> row = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			setParamValues(stmt, params);
			rs = stmt.executeQuery();
			rs.last();
			int rowSize = rs.getRow();
			if (rowSize == 1) {
				ResultSetMetaData rsMeta = rs.getMetaData();
				row = new HashMap<String, Object>();
				for (int i = 0, size = rsMeta.getColumnCount(); i < size; ++i) {
					String columName = rsMeta.getColumnLabel(i + 1).toLowerCase();
					Object value = rs.getObject(i + 1);
					row.put(columName, value);
				}
			} else {
				LOG.debug("参数错误，查询结果有多个，请使用[executeQueryMultiple]方法！");
			}
		} finally {
			close(rs);
			close(stmt);
			close(conn);
		}
		return row;*/
	}

	/**
	 * 查询单个结果
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> executeQuerySingle(String sql) throws SQLException {
		Connection conn = getConnection();
		Map<String, Object> row = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.last();
			int rowSize = rs.getRow();
			if (rowSize == 1) {
				ResultSetMetaData rsMeta = rs.getMetaData();
				row = new HashMap<String, Object>();
				for (int i = 0, size = rsMeta.getColumnCount(); i < size; ++i) {
					String columName = rsMeta.getColumnLabel(i + 1).toLowerCase();
					Object value = rs.getObject(i + 1);
					row.put(columName, value);
				}
			} else {
				LOG.debug("参数错误，查询结果有多个，请使用[executeQueryMultiple]方法！");
			}
		} finally {
			close(rs);
			close(stmt);
			close(conn);
		}
		return row;
	}

	/**
	 * 查询多个结果
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> executeQueryMultiple(String sql, List<Object> params) throws SQLException {
		return this.getJdbcTemplate().queryForList(sql, params.toArray());
		/*List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			setParamValues(stmt, params);
			rs = stmt.executeQuery();
			ResultSetMetaData rsMeta = rs.getMetaData();
			while (rs.next()) {
				Map<String, Object> row = new HashMap<String, Object>();
				for (int i = 0, size = rsMeta.getColumnCount(); i < size; ++i) {
					String columName = rsMeta.getColumnLabel(i + 1).toLowerCase();
					Object value = rs.getObject(i + 1);
					row.put(columName, value);
				}
				rows.add(row);
			}
		} finally {
			close(rs);
			close(stmt);
			close(conn);
		}
		return rows;*/
	}

	/**
	 * 条件查询多个结果
	 * 
	 * @param sql
	 * @param condition
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> executeQueryByConditionMultiple(String sql, LinkedHashMap<String, Object> condition) throws SQLException {
		StringBuffer sqlBuffer = new StringBuffer(sql.trim());
		List<Object> params = new ArrayList<Object>();
		this.makeConditionSql(condition, sqlBuffer, sql, params);
		return this.executeQueryMultiple(sqlBuffer.toString(), params);
	}
	
	/**
	 * 分页条件查询多个结果
	 * 
	 * @param sql
	 * @param condition
	 * @param page
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> executeQueryByConditionMultiple(String sql, LinkedHashMap<String, Object> condition, Page page) throws SQLException {
		StringBuffer sqlBuffer = new StringBuffer(sql.trim());
		List<Object> params = new ArrayList<Object>();
		this.makeConditionSql(condition, sqlBuffer, sql, params);
		if(null != page){
			sqlBuffer.append(" limit ?,?");
			params.add(page.getStartRecord());
			params.add(page.getPageRecord());
		}
		return this.executeQueryMultiple(sqlBuffer.toString(), params);
	}
	
	private void makeConditionSql(LinkedHashMap<String, Object> condition, StringBuffer sqlBuffer, String sql, List<Object> params) {
		if(condition.size() > 0){
			if(sql.indexOf("where") == -1){
				sqlBuffer.append(" where 1=1");
			}
			Iterator<String> keys = condition.keySet().iterator();
			while (keys.hasNext()) {
				String key = (String) keys.next();
				sqlBuffer.append(" and ").append(key).append("=?");
			}
			params.addAll(condition.values());
		}
	}
	
	/**
	 * 查询多个结果
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> executeQueryMultiple(String sql) throws SQLException {
		return this.getJdbcTemplate().queryForList(sql);
		/*List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			ResultSetMetaData rsMeta = rs.getMetaData();
			while (rs.next()) {
				Map<String, Object> row = new HashMap<String, Object>();
				for (int i = 0, size = rsMeta.getColumnCount(); i < size; ++i) {
					String columName = rsMeta.getColumnLabel(i + 1).toLowerCase();
					Object value = rs.getObject(i + 1);
					row.put(columName, value);
				}
				rows.add(row);
			}
		} finally {
			close(rs);
			close(stmt);
			close(conn);
		}
		return rows;*/
	}

	/**
	 * 赋值
	 * 
	 * @param stmt
	 * @param params
	 * @throws SQLException
	 */
	private void setParamValues(PreparedStatement stmt, List<Object> params) throws SQLException {
		for (int i = 0, size = params.size(); i < size; ++i) {
			stmt.setObject(i + 1, params.get(i));
		}
	}

	/**
	 * 按指定条件统计数据总数目
	 * 
	 * @param tableNameOrSql
	 * @param countColumn
	 * @param data
	 * @return
	 * @throws SQLException
	 */
	public int countTable(String tableNameOrSql, String countColumn, Map<String, Object> data) throws SQLException {
		if (data == null) {
			data = new LinkedHashMap<String, Object>();
		}
		String sql = makeCountTableSql(tableNameOrSql, countColumn, data.keySet());
		List<Object> params = new ArrayList<Object>(data.values());
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			stmt = conn.prepareStatement(sql);
			setParamValues(stmt, params);
			rs = stmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} finally {
			close(rs);
			close(stmt);
			close(conn);
		}
		return count;
	}

	/**
	 * 更新数据
	 * 
	 * @param tableName
	 * @param data
	 * @throws SQLException
	 */
	public void updateSourceById(String tableName, Map<String, Object> data) throws SQLException {
		String sql = makeUpdateTableSql(tableName, data.keySet());
		List<Object> params = new ArrayList<Object>(data.values());
		Object id = params.get(0);
		params.remove(0);
		params.add(id);
		execute(sql, params);
	}

	/**
	 * 新增数据
	 * 
	 * @param tableName
	 * @param data
	 * @throws SQLException
	 */
	public void insertToTable(String tableName, Map<String, Object> data) throws SQLException {
		String sql = makeInsertToTableSql(tableName, data.keySet());
		List<Object> params = new ArrayList<Object>(data.values());
		execute(sql, params);
	}

	/**
	 * 新增数据并返回对象主键ID
	 * 
	 * @param tableName
	 * @param data
	 * @return
	 * @throws SQLException
	 */
	public int insertAndReturnPrimaryId(String tableName, Map<String, Object> data) throws SQLException {
		String sql = makeInsertToTableSql(tableName, data.keySet());
		List<Object> params = new ArrayList<Object>(data.values());
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		int primaryId = 0;
		try {
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParamValues(stmt, params);
			int upadteCount = stmt.executeUpdate();
			if (upadteCount != 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				while (rs.next()) {
					primaryId = rs.getInt(1);
				}
			}
		} finally {
			close(stmt);
			close(conn);
		}
		return primaryId;
	}

	/**
	 * 新增对象并返回对象全部内容
	 * 
	 * @param tableName
	 * @param data
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> insertAndReturnObject(String tableName, Map<String, Object> data) throws SQLException {
		StringBuilder sql = new StringBuilder().append("select ");
		Collection<String> names = data.keySet();
		int nameCount = 0;
		for (String name : names) {
			if (nameCount > 0) {
				sql.append(",");
			}
			sql.append("t." + name);
			nameCount++;
		}
		sql.append(" from ").append(tableName).append(" where t.id = ?");
		Object primaryId = insertAndReturnPrimaryId(tableName, data);
		Map<String, Object> returnData = executeQuerySingle(sql.toString(), Arrays.asList(primaryId));
		return returnData;
	}

	/**
	 * 新增数据并返回对象指定内容
	 * 
	 * @param sql
	 * @param tableName
	 * @param data
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> insertAndReturnObject(String sql, String tableName, Map<String, Object> data)
			throws SQLException {
		Object primaryId = insertAndReturnPrimaryId(tableName, data);
		Map<String, Object> returnData = executeQuerySingle(sql, Arrays.asList(primaryId));
		return returnData;
	}

	/**
	 * 生成查询总条数SQL
	 * 
	 * @param tableNameOrSql
	 * @param countColumn
	 * @param paramNames
	 * @return
	 */
	public String makeCountTableSql(String tableNameOrSql, String countColumn, Collection<String> paramNames) {
		StringBuilder sql = new StringBuilder().append("select count(").append(countColumn).append(") as count from ")
				.append(tableNameOrSql);
		if (paramNames != null && paramNames.size() > 0) {
			int nameCount = 0;
			sql.append(" where ");
			for (String string : paramNames) {
				if (nameCount > 0) {
					sql.append(" and ");
				}
				sql.append(string).append(" = ?");
				nameCount++;
			}
		}
		return sql.toString();
	}

	/**
	 * 生成新增数据SQL
	 * 
	 * @param tableName
	 * @param names
	 * @return
	 */
	public String makeInsertToTableSql(String tableName, Collection<String> names) {
		StringBuilder sql = new StringBuilder().append("insert into ").append(tableName).append("(");
		int nameCount = 0;
		for (String name : names) {
			if (nameCount > 0) {
				sql.append(",");
			}
			sql.append(name);
			nameCount++;
		}
		sql.append(") values (");
		for (int i = 0; i < nameCount; ++i) {
			if (i != 0) {
				sql.append(",");
			}
			sql.append("?");
		}
		sql.append(")");
		return sql.toString();
	}

	/**
	 * 生成更新数据SQL
	 * 
	 * @param tableName
	 * @param names
	 * @return
	 */
	public String makeUpdateTableSql(String tableName, Collection<String> names) {
		StringBuilder sql = new StringBuilder().append("update ").append(tableName).append(" set ");
		int nameCount = 0;
		for (String name : names) {
			if (!name.equals("id")) {
				sql.append(name);
				if (names.size() > 0 && nameCount < names.size() - 1) {
					sql.append("= ? ,");
				} else {
					sql.append("= ?");
				}
			}
			nameCount++;
		}
		sql.append(" where id = ?");
		return sql.toString();
	}

	/**
	 * 关闭Connection
	 * 
	 * @param x
	 */
	public final void close(Connection x) {
		if (x != null) {
			try {
				x.close();
			} catch (Exception e) {
				LOG.error("关闭 Connection 时出错", e);
			}
		}
	}

	/**
	 * 关闭Statement
	 * 
	 * @param x
	 */
	public final void close(Statement x) {
		if (x != null) {
			try {
				x.close();
			} catch (Exception e) {
				LOG.error("关闭 Statement 时出错", e);
			}
		}
	}

	/**
	 * 关闭ResultSet
	 * 
	 * @param x
	 */
	public final void close(ResultSet x) {
		if (x != null) {
			try {
				x.close();
			} catch (Exception e) {
				LOG.error("关闭 Resultset 时出错", e);
			}
		}
	}

	/**
	 * 关闭Closeable
	 * 
	 * @param x
	 */
	public final void close(Closeable x) {
		if (x != null) {
			try {
				x.close();
			} catch (Exception e) {
				LOG.error("关闭时出错", e);
			}
		}
	}
}
