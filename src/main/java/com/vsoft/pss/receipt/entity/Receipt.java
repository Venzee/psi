package com.vsoft.pss.receipt.entity;

import java.io.Serializable;
import java.util.Date;

public class Receipt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6362812078414111806L;
	private int id;
	private int serialId;// 流水号
	private Date createDate;// 创建时间
	private Date checkDate;// 审核时间
	private Date postedDate;// 过账时间
	private Double totalMoney;// 总金额
	private int customerId;// 客户ID
	private int supplierId;// 供应商ID
	private int outWareId; // 出货仓库
	private int inWareId;// 收货仓库
	private int handleEmpId;// 经手员工ID
	private int checkEmpId;// 审核员工ID
	private int postedEmpId;// 过账员工ID
	private int status;// 单据状态 1为等待审核，2为已审核等待过账，3为已过帐未收款，4为已收款
	private int type;// 单据类型 1为进货单，2为销售单，3为销售退货单，4为进货退货单，5为调拨单，0为无效
	private int companyId;// 单据所属公司ID
	private String remark;// 备注

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSerialId() {
		return serialId;
	}

	public void setSerialId(int serialId) {
		this.serialId = serialId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getOutWareId() {
		return outWareId;
	}

	public void setOutWareId(int outWareId) {
		this.outWareId = outWareId;
	}

	public int getInWareId() {
		return inWareId;
	}

	public void setInWareId(int inWareId) {
		this.inWareId = inWareId;
	}

	public int getHandleEmpId() {
		return handleEmpId;
	}

	public void setHandleEmpId(int handleEmpId) {
		this.handleEmpId = handleEmpId;
	}

	public int getCheckEmpId() {
		return checkEmpId;
	}

	public void setCheckEmpId(int checkEmpId) {
		this.checkEmpId = checkEmpId;
	}

	public int getPostedEmpId() {
		return postedEmpId;
	}

	public void setPostedEmpId(int postedEmpId) {
		this.postedEmpId = postedEmpId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
