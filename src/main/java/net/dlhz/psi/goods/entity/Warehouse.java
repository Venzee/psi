package net.dlhz.psi.goods.entity;

/**
 * 仓库
 * 
 * @author Venz
 * 
 */
public class Warehouse implements java.io.Serializable {

	private static final long serialVersionUID = -5904025649484887697L;
	private int id;
	private String name;
	private String addr;
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

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getComId() {
		return this.comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

}