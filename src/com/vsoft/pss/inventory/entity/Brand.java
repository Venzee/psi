package com.vsoft.pss.inventory.entity;

import java.io.Serializable;

public class Brand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4973097054647915975L;
	private int id;
	private String name; // 品牌名称
	private int creatCompanyId; // 新建品牌的公司ID 0为全部可见(默认)

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

	public int getCreatCompanyId() {
		return creatCompanyId;
	}

	public void setCreatCompanyId(int creatCompanyId) {
		this.creatCompanyId = creatCompanyId;
	}

}
