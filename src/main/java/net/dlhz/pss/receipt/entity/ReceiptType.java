package net.dlhz.pss.receipt.entity;

import java.io.Serializable;

public class ReceiptType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -417381651627800363L;
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
