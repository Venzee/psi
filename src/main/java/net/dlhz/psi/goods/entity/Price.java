package net.dlhz.psi.goods.entity;

/**
 * 价格
 * 
 * @author Venz
 * 
 */
public class Price implements java.io.Serializable {

	private static final long serialVersionUID = 7403688780433614812L;
	private int id;
	private int skuId;
	private double price;
	private int status;

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

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}