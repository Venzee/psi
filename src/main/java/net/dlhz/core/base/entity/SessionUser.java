package net.dlhz.core.base.entity;

import java.io.Serializable;

public class SessionUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1459780316620015497L;
	private int userId; // 用户ID
	private String username; // 用户名
	private int groupId; // 用户组ID
	private int employeeId; // 员工ID
	private int companyId; // 公司ID
	private String powers; // 权限串
	private String sorts; // 可销售商品类型
	private String companyName; // 公司名称
	private String groupName; // 用户组名称
	private String employeeName; // 员工名称
	private String departmentName; // 部门名称
	// private Date expireDate; //平台到期时间
	private boolean master; // 是否总公司
	// private Date employeeBirth; //员工生日
	private int status;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getPowers() {
		return powers;
	}

	public void setPowers(String powers) {
		this.powers = powers;
	}

	public String getSorts() {
		return sorts;
	}

	public void setSorts(String sorts) {
		this.sorts = sorts;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public boolean isMaster() {
		return master;
	}

	public void setMaster(boolean master) {
		this.master = master;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
