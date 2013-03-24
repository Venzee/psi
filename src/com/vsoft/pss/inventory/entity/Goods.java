package com.vsoft.pss.inventory.entity;

import java.io.Serializable;

public class Goods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7253715318320803920L;
	private int id;
	private String shortname; // 商品简称
	private String name; // 商品全名
	private int brandId;// 品牌ID
	private int sortId;// 类型ID
	private String barcode; // 商品条码
	private String unit;// 商品单位
	private String seasonIds;// 商品可销售季节IDs
	private String code;// 编码，用于快速搜索，一般为商品简称拼音首字母缩写
	private String remark;
	private int creatCompanyId; // 新建商品的公司ID 0为全部(默认)

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getSortId() {
		return sortId;
	}

	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSeasonIds() {
		return seasonIds;
	}

	public void setSeasonIds(String seasonIds) {
		this.seasonIds = seasonIds;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getCreatCompanyId() {
		return creatCompanyId;
	}

	public void setCreatCompanyId(int creatCompanyId) {
		this.creatCompanyId = creatCompanyId;
	}

}
