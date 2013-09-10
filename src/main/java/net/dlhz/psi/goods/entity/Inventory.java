package net.dlhz.psi.goods.entity;

/**
 * 库存
 * 
 * @author Venz
 * 
 */
public class Inventory implements java.io.Serializable {

	private static final long serialVersionUID = -4370718161204878546L;
	private int id;
	private int skuId;
	private int serialId;
	private double num;
	private double inprice;
	private int whId;
	private int comId;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSkuId() {
		return this.skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}

	public int getSerialId() {
		return this.serialId;
	}

	public void setSerialId(int serialId) {
		this.serialId = serialId;
	}

	public double getNum() {
		return this.num;
	}

	public void setNum(double num) {
		this.num = num;
	}

	public double getInprice() {
		return this.inprice;
	}

	public void setInprice(double inprice) {
		this.inprice = inprice;
	}

	public int getWhId() {
		return this.whId;
	}

	public void setWhId(int whId) {
		this.whId = whId;
	}

	public int getComId() {
		return this.comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

}