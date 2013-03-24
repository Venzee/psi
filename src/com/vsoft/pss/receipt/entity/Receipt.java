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
	private int customerId;// 客户ID
	private int supplierId;// 供应商ID
	private int outWarehouseId; // 出货仓库
	private int inWarehouseId;// 收货仓库
	private int handleEmployeeId;// 经手员工ID
	private int checkEmployeeId;// 审核员工ID
	private int postedEmployeeId;// 过账员工ID
	private int status;// 单据状态 1为等待审核，2为已审核等待过账，3为已过帐未收款，4为已收款
	private int type;// 单据类型 1为进货单，2为销售单，3为销售退货单，4为进货退货单，5为调拨单，0为无效
	private int companyId;// 单据所属公司ID

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

	public int getOutWarehouseId() {
		return outWarehouseId;
	}

	public void setOutWarehouseId(int outWarehouseId) {
		this.outWarehouseId = outWarehouseId;
	}

	public int getInWarehouseId() {
		return inWarehouseId;
	}

	public void setInWarehouseId(int inWarehouseId) {
		this.inWarehouseId = inWarehouseId;
	}

	public int getHandleEmployeeId() {
		return handleEmployeeId;
	}

	public void setHandleEmployeeId(int handleEmployeeId) {
		this.handleEmployeeId = handleEmployeeId;
	}

	public int getCheckEmployeeId() {
		return checkEmployeeId;
	}

	public void setCheckEmployeeId(int checkEmployeeId) {
		this.checkEmployeeId = checkEmployeeId;
	}

	public int getPostedEmployeeId() {
		return postedEmployeeId;
	}

	public void setPostedEmployeeId(int postedEmployeeId) {
		this.postedEmployeeId = postedEmployeeId;
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

}
