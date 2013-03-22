package com.vsoft.jxc.inventory.entity;

import java.io.Serializable;

public class Season implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7994163506993919862L;
	private int id;
	private String name;

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

}
