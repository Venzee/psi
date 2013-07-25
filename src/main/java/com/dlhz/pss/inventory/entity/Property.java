package com.dlhz.pss.inventory.entity;

import java.io.Serializable;
import java.util.Date;

public class Property implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3721879975263859052L;
	private int id;
	private String name; // 属性名称
	private int sortId; // 类别ID
	private Date createDate; // 创建时间

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

	public int getSortId() {
		return sortId;
	}

	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
