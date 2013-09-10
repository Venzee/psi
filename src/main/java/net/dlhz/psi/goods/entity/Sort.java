package net.dlhz.psi.goods.entity;

/**
 * 商品类型
 * 
 * @author Venz
 * 
 */
public class Sort implements java.io.Serializable {

	private static final long serialVersionUID = 8394123246707983070L;
	private int id;
	private String name;
	private int parentId;
	private int comId;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getComId() {
		return this.comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

}