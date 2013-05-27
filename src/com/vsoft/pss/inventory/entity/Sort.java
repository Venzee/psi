package com.vsoft.pss.inventory.entity;

import java.io.Serializable;

public class Sort implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1161754471073887807L;
	private int id;
	private String name; // 类别名称
	private String code; // 编码(名称首字母)
	private int parentId; // 父级ID
	private boolean main; // 主要类目(即初始加载类目)
	private boolean hasChild; // 是否有下属类目

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public boolean isMain() {
		return main;
	}

	public void setMain(boolean main) {
		this.main = main;
	}

	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

}
