package net.dlhz.psi.base.entity;

/**
 * 部门
 * 
 * @author Venz
 * 
 */
public class Department implements java.io.Serializable {

	private static final long serialVersionUID = -84376594563663345L;
	private int id;
	private String name;
	private int empId;
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

	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getComId() {
		return this.comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

}