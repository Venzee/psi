package net.dlhz.psi.sys.entity;

/**
 * 文件
 * 
 * @author Venz
 * 
 */
public class File implements java.io.Serializable {

	private static final long serialVersionUID = 2783736471715411480L;
	private int id;
	private String md5;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMd5() {
		return this.md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

}