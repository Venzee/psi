package net.dlhz.psi.receipt.entity;

import java.util.Date;

/**
 * 单据
 * 
 * @author Venz
 * 
 */
public class Receipt implements java.io.Serializable {

	private static final long serialVersionUID = 7739214322432187299L;
	private int id;
	private int serialId;
	private Date createDate;
	private Date checkDate;
	private Date postedDate;
	private double totalMoney;
	private double totleNum;
	private int custId;
	private int supId;
	private int outwhId;
	private int inwhId;
	private String handleEmps;
	private int checkEmpId;
	private int postedEmpId;
	private int status;
	private int type;
	private double rebate;
	private double discount;
	private int comId;
	private String remark;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSerialId() {
		return this.serialId;
	}

	public void setSerialId(int serialId) {
		this.serialId = serialId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public Date getPostedDate() {
		return this.postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public double getTotalMoney() {
		return this.totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public double getTotleNum() {
		return this.totleNum;
	}

	public void setTotleNum(double totleNum) {
		this.totleNum = totleNum;
	}

	public int getCustId() {
		return this.custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getSupId() {
		return this.supId;
	}

	public void setSupId(int supId) {
		this.supId = supId;
	}

	public int getOutwhId() {
		return this.outwhId;
	}

	public void setOutwhId(int outwhId) {
		this.outwhId = outwhId;
	}

	public int getInwhId() {
		return this.inwhId;
	}

	public void setInwhId(int inwhId) {
		this.inwhId = inwhId;
	}

	public String getHandleEmps() {
		return this.handleEmps;
	}

	public void setHandleEmps(String handleEmps) {
		this.handleEmps = handleEmps;
	}

	public int getCheckEmpId() {
		return this.checkEmpId;
	}

	public void setCheckEmpId(int checkEmpId) {
		this.checkEmpId = checkEmpId;
	}

	public int getPostedEmpId() {
		return this.postedEmpId;
	}

	public void setPostedEmpId(int postedEmpId) {
		this.postedEmpId = postedEmpId;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getRebate() {
		return this.rebate;
	}

	public void setRebate(double rebate) {
		this.rebate = rebate;
	}

	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getComId() {
		return this.comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}