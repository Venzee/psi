package net.dlhz.psi.receipt.entity;

/**
 * 
 * 
 * @author Venz
 * 
 */
public class Sales implements java.io.Serializable {

	private static final long serialVersionUID = 8407736520613148555L;
	private int id;
	private int rcpId;
	private double num;
	private double money;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRcpId() {
		return this.rcpId;
	}

	public void setRcpId(int rcpId) {
		this.rcpId = rcpId;
	}

	public double getNum() {
		return this.num;
	}

	public void setNum(double num) {
		this.num = num;
	}

	public double getMoney() {
		return this.money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

}