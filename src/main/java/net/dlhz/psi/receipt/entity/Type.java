package net.dlhz.psi.receipt.entity;

/**
 * 单据类型
 * 
 * @author Venz
 * 
 */
public class Type implements java.io.Serializable {

	private static final long serialVersionUID = 3891501578063168390L;
	private int id;
	private String name;

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

}