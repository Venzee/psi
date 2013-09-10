package net.dlhz.psi.goods.entity;

/**
 * 属性
 * 
 * @author Venz
 * 
 */
public class Prop implements java.io.Serializable {

	private static final long serialVersionUID = -1484436562472469763L;
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