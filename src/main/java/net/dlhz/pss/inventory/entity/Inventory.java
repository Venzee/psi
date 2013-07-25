package net.dlhz.pss.inventory.entity;

import java.io.Serializable;

public class Inventory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9074780469982007230L;
	private int id;
	private int num;// 库存数
	private int goodsId;// 商品编号
	private int serialId;// 流水号
	private Double inprice;// 进货价
	private int warehouseId;// 仓库ID
	private int companyId;// 记录所属公司ID

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

	public int getSerialId() {
		return serialId;
	}

	public void setSerialId(int serialId) {
		this.serialId = serialId;
	}

	public Double getInprice() {
		return inprice;
	}

	public void setInprice(Double inprice) {
		this.inprice = inprice;
	}

	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

}
