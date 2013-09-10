package net.dlhz.psi.receipt.entity;

/**
 * 单据明细
 * 
 * @author Venz
 * 
 */
public class Record implements java.io.Serializable {

	private static final long serialVersionUID = -6647306020012174903L;
	private int id;
	private double num;
	private int skuId;
	private double inprice;
	private double price;
	private double totalMoney;
	private int rcpId;
	private double rebate;
	private double discount;
	private String remark;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getNum() {
		return this.num;
	}

	public void setNum(double num) {
		this.num = num;
	}

	public int getSkuId() {
		return this.skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}

	public double getInprice() {
		return this.inprice;
	}

	public void setInprice(double inprice) {
		this.inprice = inprice;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotalMoney() {
		return this.totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public int getRcpId() {
		return this.rcpId;
	}

	public void setRcpId(int rcpId) {
		this.rcpId = rcpId;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}