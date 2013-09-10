package net.dlhz.psi.goods.entity;

/**
 * 商品
 * 
 * @author Venz
 * 
 */
public class Goods implements java.io.Serializable {

	private static final long serialVersionUID = -7681995946399029641L;
	private int id;
	private String same;
	private String name;
	private String ename;
	private int brandId;
	private int sortId;
	private int status;
	private int comId;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSame() {
		return this.same;
	}

	public void setSame(String same) {
		this.same = same;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getBrandId() {
		return this.brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getSortId() {
		return this.sortId;
	}

	public void setSortId(int sortId) {
		this.sortId = sortId;
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

}