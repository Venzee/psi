package net.dlhz.psi.base.entity;

import java.io.Serializable;

public class Industry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3797818031144768141L;
	private int id;//
	private String name;// 行业名称
	private String description; // 行业描述
	private String sorts; // 行业默认可销售商品类目

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSorts() {
		return sorts;
	}

	public void setSorts(String sorts) {
		this.sorts = sorts;
	}

}
