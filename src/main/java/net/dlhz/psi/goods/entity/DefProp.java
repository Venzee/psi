package net.dlhz.psi.goods.entity;

/**
 * 商品默认属性
 * 
 * @author Venz
 * 
 */
public class DefProp implements java.io.Serializable {

	private static final long serialVersionUID = 8786525122293200890L;
	private int id;
	private int goodsId;
	private int propId;
	private int propValId;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getPropId() {
		return this.propId;
	}

	public void setPropId(int propId) {
		this.propId = propId;
	}

	public int getPropValId() {
		return this.propValId;
	}

	public void setPropValId(int propValId) {
		this.propValId = propValId;
	}

}