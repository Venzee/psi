package net.dlhz.psi.inventory.entity.form;

import java.io.Serializable;

public class SortForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8823889129386956953L;
	private String role;
	private Object object;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}
