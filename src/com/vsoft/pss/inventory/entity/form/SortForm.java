package com.vsoft.pss.inventory.entity.form;

import java.io.Serializable;

import com.vsoft.pss.inventory.entity.Sort;

public class SortForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8823889129386956953L;
	private Sort sort;
	private String topName;

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public String getTopName() {
		return topName;
	}

	public void setTopName(String topName) {
		this.topName = topName;
	}

}
