package com.dlhz.pss.inventory.entity;

import java.io.Serializable;

public class Price implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6205972964405838682L;
	private int id;
	private int goodsId;// 商品ID
	private Double salePrice; // 销售价格
	private int status; // 状态
	private int companyId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

}
