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
	private Sort sort;
	private List<Sort> childList;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public List<Sort> getChildList() {
		return childList;
	}

	public void setChildList(List<Sort> childList) {
		this.childList = childList;
	}

}
