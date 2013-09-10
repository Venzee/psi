package net.dlhz.psi.base.entity;

import java.util.Date;

/**
 * 公司
 * 
 * @author Venz
 * 
 */
public class Company implements java.io.Serializable {

	private static final long serialVersionUID = 1409154983202187201L;
	private int id;
	private String name;
	private String email;
	private String contact;
	private String tel;
	private String fax;
	private String addr;
	private int indusId;
	private int comId;
	private Date joinDate;
	private Date expireDate;
	private boolean master;

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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getIndusId() {
		return this.indusId;
	}

	public void setIndusId(int indusId) {
		this.indusId = indusId;
	}

	public int getComId() {
		return this.comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

	public Date getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public boolean getMaster() {
		return this.master;
	}

	public void setMaster(boolean master) {
		this.master = master;
	}

}