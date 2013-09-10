package net.dlhz.psi.goods.entity;

import java.util.Date;

/**
 * 商品品牌
 * 
 * @author Venz
 * 
 */
public class Brand implements java.io.Serializable {

	private static final long serialVersionUID = 1161415038135848880L;
	private int id;
	private String name;
	private String ename;
	private String logo;
	private String remark;
	private int status;
	private Date createDate;
	private int sortId;
	private int comId;
	
	//
	private String sortName;
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getSortId() {
		return this.sortId;
	}

	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

	public int getComId() {
		return this.comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

}