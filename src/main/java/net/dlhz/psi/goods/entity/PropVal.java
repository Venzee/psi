package net.dlhz.psi.goods.entity;

/**
 * 属性对应值
 * 
 * @author Venz
 * 
 */
public class PropVal implements java.io.Serializable {

	private static final long serialVersionUID = 5149802499038756796L;
	private int id;
	private String value;
	private int skuId;
	private int propId;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getSkuId() {
		return this.skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}

	public int getPropId() {
		return this.propId;
	}

	public void setPropId(int propId) {
		this.propId = propId;
	}

}