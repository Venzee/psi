package com.vsoft.pss.receipt.entity;

import java.io.Serializable;
import java.util.List;

public class ReceiptForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2442129485795356480L;
	private Receipt receipt;
	private List<Record> records;

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

}
