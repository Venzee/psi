package net.dlhz.psi.relation.entity;

/**
 * 往来单位设置
 * 
 * @author Venz
 * 
 */
public class Setting implements java.io.Serializable {

	private static final long serialVersionUID = -4619729040744625831L;
	private int id;
	private double price;
	private double rebate;
	private double discount;
	private int skuId;
	private int comId;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public int getSkuId() {
		return this.skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}

	public int getComId() {
		return this.comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

}