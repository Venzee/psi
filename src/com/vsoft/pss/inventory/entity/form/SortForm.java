package com.vsoft.pss.inventory.entity.form;

import java.io.Serializable;
import java.util.List;

import com.vsoft.pss.inventory.entity.Sort;

public class SortForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8823889129386956953L;
	private String code;
	private String role;
	private Sort sort;
	private List<Object> childList;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public List<Object> getChildList() {
		return childList;
	}

	public void setChildList(List<Object> childList) {
		this.childList = childList;
	}

}
