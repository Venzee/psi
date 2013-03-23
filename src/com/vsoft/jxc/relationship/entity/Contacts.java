package com.vsoft.jxc.relationship.entity;

import java.io.Serializable;

public class Contacts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6992809248914449330L;
	private int id;
	private String name;// 客户名称
	private String contact;// 联系人
	private String phone;// 联系电话
	private String fax;// 传真
	private String address;// 联系地址
	private String remark;
	private int type;// 往来单位类型 1为客户，2为供货商，3为代理商
	private int companyId;// 信息所属公司ID

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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

}
