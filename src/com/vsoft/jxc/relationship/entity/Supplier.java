package com.vsoft.jxc.relationship.entity;

import java.io.Serializable;

public class Supplier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5061899606894272335L;
	private int id;
	private String name;// 供应商名称
	private String contact;// 联系方式
	private String fax;// 传真
	private String address;// 联系地址
	private String bankName;// 银行名称
	private String bankCardNo;// 银行卡号
	private String remark;
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

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

}
