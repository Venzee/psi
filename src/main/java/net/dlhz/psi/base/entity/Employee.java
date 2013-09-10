package net.dlhz.psi.base.entity;

import java.util.Date;

/**
 * 员工
 * 
 * @author Venz
 * 
 */
public class Employee implements java.io.Serializable {

	private static final long serialVersionUID = -8813010876212589379L;
	private int id;
	private int age;
	private Date birth;
	private String name;
	private String card;
	private String phone;
	private String addr;
	private int status;
	private int comId;
	private int deptId;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCard() {
		return this.card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
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

	public int getDeptId() {
		return this.deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

}