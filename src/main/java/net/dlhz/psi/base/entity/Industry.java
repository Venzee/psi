package net.dlhz.psi.base.entity;

/**
 * 行业
 * 
 * @author Venz
 * 
 */
public class Industry implements java.io.Serializable {

	private static final long serialVersionUID = -3557042719263452988L;
	private int id;
	private String name;
	private String remark;
	private String sorts;

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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSorts() {
		return this.sorts;
	}

	public void setSorts(String sorts) {
		this.sorts = sorts;
	}

}