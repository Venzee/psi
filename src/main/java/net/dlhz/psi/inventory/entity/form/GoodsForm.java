package net.dlhz.psi.inventory.entity.form;

import java.io.Serializable;

import net.dlhz.psi.inventory.entity.Goods;


public class GoodsForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3306392383768057648L;
	private Goods goods;
	private String sortName;

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

}
