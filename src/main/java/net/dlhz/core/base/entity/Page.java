package net.dlhz.core.base.entity;

import java.io.Serializable;

public class Page implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3041436827544897993L;
	private int currPage = 1;// 当前页码,默认1
	private int totalPage = 1;// 总页数
	private int count = 0;// 总记录数
	private int pageRecord = 10;// 每页记录数
	private int startRecord = 1;// 开始记录数

	/**
	 * 初使化
	 * 
	 * @param count 总记录数
	 * @param rpp 每页记录数
	 */
	public void init(int count) {
		setCount(count);// 总记录数
		if (getPageRecord() < 10 || getPageRecord() > 100) {
			setPageRecord(pageRecord);// 每页记录数
		}
		setStartRecord((currPage - 1) * this.pageRecord);// 查询开始记录数
		if(count % this.pageRecord == 0){
			setTotalPage(count / this.pageRecord);// 总页数
		}else{
			setTotalPage(count / this.pageRecord + 1);// 总页数
		}
		
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageRecord() {
		return pageRecord;
	}

	public void setPageRecord(int pageRecord) {
		this.pageRecord = pageRecord;
	}

	public int getStartRecord() {
		return startRecord;
	}

	public void setStartRecord(int startRecord) {
		this.startRecord = startRecord;
	}

}
