package net.dlhz.psi.goods.entity;

import java.util.Date;

/**
 * SKU
 * 
 * @author Venz
 * 
 */
public class Sku implements java.io.Serializable {

	private static final long serialVersionUID = -2646764295591746222L;
	private int id;
	private int goodsId;
	private String name;
	private byte[] code;
	private String barcode;
	private String scode;
	private String propStr;
	private int priceId;
	private int status;
	private int comId;
	private String remark;
	private Date createDate;

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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getCode() {
		return this.code;
	}

	public void setCode(byte[] code) {
		this.code = code;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getScode() {
		return this.scode;
	}

	public void setScode(String scode) {
		this.scode = scode;
	}

	public String getPropStr() {
		return this.propStr;
	}

	public void setPropStr(String propStr) {
		this.propStr = propStr;
	}

	public int getPriceId() {
		return this.priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getComId() {
		return this.comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}