package net.dlhz.psi.user.entity;

/**
 * 权限
 * 
 * @author Venz
 * 
 */
public class Power implements java.io.Serializable {

	private static final long serialVersionUID = 2038623972276629597L;
	private int id;
	private String name;
	private String code;
	private String remark;

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

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}