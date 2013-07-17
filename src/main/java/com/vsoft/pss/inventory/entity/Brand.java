package com.vsoft.pss.inventory.entity;

import java.io.Serializable;
import java.util.Date;

public class Brand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4973097054647915975L;
	private int id;
	private String name; // 品牌名称
	private String englishName; // 品牌英文名
	private String code;// 编码
	private String logo; // logo
	private String remark; // 备注&描述
	private int status; // 状态
	private Date createDate; // 创建时间
	private int sortId; // 品牌所属类目ID
	private int companyId; // 新建品牌的公司ID (默认0)

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

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getSortId() {
		return sortId;
	}

	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

}
