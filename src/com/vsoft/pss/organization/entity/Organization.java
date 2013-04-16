package com.vsoft.pss.organization.entity;

import java.io.Serializable;
import java.util.Date;

public class Organization implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7839501101526272363L;
	private int id;// 
	private int industryId;// 行业ID
	private String name;// 组织机构名称
	private Date joinDate;// 注册时间
	private Date expireDate;// 到期时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIndustryId() {
		return industryId;
	}

	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

}
