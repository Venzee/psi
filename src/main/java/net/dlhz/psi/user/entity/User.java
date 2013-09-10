package net.dlhz.psi.user.entity;

import java.util.Date;

/**
 * 用户
 * 
 * @author Venz
 * 
 */
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1193061932662346669L;
	private int id;
	private String username;
	private String password;
	private int groupId;
	private int empId;
	private int comId;
	private String powers;
	private int status;
	private Date createDate;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getComId() {
		return this.comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

	public String getPowers() {
		return this.powers;
	}

	public void setPowers(String powers) {
		this.powers = powers;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}