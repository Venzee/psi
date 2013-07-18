package com.vsoft.pss.inventory.entity;

import java.io.Serializable;

public class GoodsProperty implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3394760144357089169L;
	private int id;
	private int propId;
	private int propValId;
	private int goodsId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getPropId() {
		return propId;
	}

	public void setPropId(int propId) {
		this.propId = propId;
	}

	public int getPropValId() {
		return propValId;
	}

	public void setPropValId(int propValId) {
		this.propValId = propValId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

}
