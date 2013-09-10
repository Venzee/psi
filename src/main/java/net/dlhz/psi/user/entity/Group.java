package net.dlhz.psi.user.entity;

/**
 * 用户组
 * 
 * @author Venz
 * 
 */
public class Group implements java.io.Serializable {

	private static final long serialVersionUID = -7887459259994758787L;
	private int id;
	private String name;
	private String powers;

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

	public String getPowers() {
		return this.powers;
	}

	public void setPowers(String powers) {
		this.powers = powers;
	}

}