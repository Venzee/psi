package com.vsoft.pss.inventory.entity;

import java.io.Serializable;

public class Sort implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1161754471073887807L;
	private int id;
	private String name; // 类别名称
	private int parentId; // 父级ID
	private boolean parent; // 是否是父级

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

	public boolean isParent() {
		return parent;
	}

	public void setParent(boolean parent) {
		this.parent = parent;
	}

}
