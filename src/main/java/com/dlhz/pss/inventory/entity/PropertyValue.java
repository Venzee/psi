package com.dlhz.pss.inventory.entity;

import java.io.Serializable;
import java.util.Date;

public class PropertyValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6952399715023492842L;
	private int id;
	private int propertyId; // 属性ID
	private String value; // 值
	private Date createDate; // 创建时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
