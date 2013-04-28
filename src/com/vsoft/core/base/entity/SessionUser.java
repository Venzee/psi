package com.vsoft.core.base.entity;

import java.io.Serializable;

public class SessionUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1459780316620015497L;
	private String username; // 用户名
	private String rights; // 权限串

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}

}
