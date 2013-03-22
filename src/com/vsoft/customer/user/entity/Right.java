package com.vsoft.customer.user.entity;

import java.io.Serializable;

public class Right implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 450306277333347257L;
	private int id;
	private String name; // 权限名称
	private String remark;// 备注

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
