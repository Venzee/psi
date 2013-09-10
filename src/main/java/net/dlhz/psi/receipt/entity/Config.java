package net.dlhz.psi.receipt.entity;

/**
 * 单据配置
 * 
 * @author Venz
 * 
 */
public class Config implements java.io.Serializable {

	private static final long serialVersionUID = -2460117032437418665L;
	private int id;
	private boolean needCheck;
	private boolean needDraft;
	private int serialLength;
	private int rcpTypeId;
	private int rcpStyle;
	private int comId;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getNeedCheck() {
		return this.needCheck;
	}

	public void setNeedCheck(boolean needCheck) {
		this.needCheck = needCheck;
	}

	public boolean getNeedDraft() {
		return this.needDraft;
	}

	public void setNeedDraft(boolean needDraft) {
		this.needDraft = needDraft;
	}

	public int getSerialLength() {
		return this.serialLength;
	}

	public void setSerialLength(int serialLength) {
		this.serialLength = serialLength;
	}

	public int getRcpTypeId() {
		return this.rcpTypeId;
	}

	public void setRcpTypeId(int rcpTypeId) {
		this.rcpTypeId = rcpTypeId;
	}

	public int getRcpStyle() {
		return this.rcpStyle;
	}

	public void setRcpStyle(int rcpStyle) {
		this.rcpStyle = rcpStyle;
	}

	public int getComId() {
		return this.comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

}