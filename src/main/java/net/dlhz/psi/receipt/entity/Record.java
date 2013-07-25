package net.dlhz.psi.receipt.entity;

import java.io.Serializable;

public class Record implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8111638833035538599L;
	private int id;
	private double num;// 数量
	private int skuId;// 商品ID
	private double inprice;// 进货价
	private double price;// 销售价格
	private double totalMoney;// 金额
	private int receiptId;// 单据编号
	private double rebate;
	private double discount;
	private String remark;// 备注

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getNum() {
		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}

	public int getSkuId() {
		return skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}

	public double getInprice() {
		return inprice;
	}

	public void setInprice(double inprice) {
		this.inprice = inprice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public int getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}

	public double getRebate() {
		return rebate;
	}

	public void setRebate(double rebate) {
		this.rebate = rebate;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
