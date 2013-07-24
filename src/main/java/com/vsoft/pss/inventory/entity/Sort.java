package com.vsoft.pss.inventory.entity;

import java.io.Serializable;

public class Sort implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4545463087259730825L;
	private int id;
	private String name;
	private int parentId;

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

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

}
