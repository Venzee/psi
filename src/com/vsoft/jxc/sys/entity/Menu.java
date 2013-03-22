/*-------------------------------------------------
 * Project:　　  test
 * FileName:    Menu.java
 * PackageName: com.vsoft.jxc.sys.entity
 * Company:     Sentree
 * Copyright:   ©2013 Sentree Co.
 * Version:     1.0
 * History:     Mar 18, 2013 12:14:27 PM (zw) Create
 *------------------------------------------------*/

package com.vsoft.jxc.sys.entity;

import java.io.Serializable;

public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4973360115875622692L;
	private int id;
	private String name;
	private String url;
	private int ascriptionId;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getAscriptionId() {
		return ascriptionId;
	}

	public void setAscriptionId(int ascriptionId) {
		this.ascriptionId = ascriptionId;
	}

}
