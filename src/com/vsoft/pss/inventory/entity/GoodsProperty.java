package com.vsoft.pss.inventory.entity;

import java.io.Serializable;

public class GoodsProperty implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3394760144357089169L;
	private int id;
	private int propertyId;
	private int propertyValueId;
	private int goodsId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public int getPropertyValueId() {
		return propertyValueId;
	}

	public void setPropertyValueId(int propertyValueId) {
		this.propertyValueId = propertyValueId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

}
