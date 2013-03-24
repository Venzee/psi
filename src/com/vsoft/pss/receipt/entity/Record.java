package com.vsoft.pss.receipt.entity;

import java.io.Serializable;

public class Record implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8111638833035538599L;
	private int id;
	private int num;// 数量
	private int goodsId;// 商品ID
	private Double inprice;// 进货价
	private Double price;// 销售价格
	private int receiptId;// 单据编号

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public Double getInprice() {
		return inprice;
	}

	public void setInprice(Double inprice) {
		this.inprice = inprice;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}

}
