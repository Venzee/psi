package com.vsoft.pss.receipt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsoft.core.base.entity.Page;
import com.vsoft.core.util.DataUtil;
import com.vsoft.pss.receipt.dao.ReceiptDao;
import com.vsoft.pss.receipt.dao.RecordDao;
import com.vsoft.pss.receipt.entity.Receipt;
import com.vsoft.pss.receipt.entity.Record;
import com.vsoft.pss.receipt.entity.form.ReceiptForm;

@Service
public class ReceiptService {

	@Autowired
	private ReceiptDao receiptDao;

	@Autowired
	private RecordDao recordDao;

	public void addReceipt(ReceiptForm receiptForm) {
		Map<String, Object> receiptData = DataUtil.parseObjectToMap(receiptForm.getReceipt(), Receipt.class);
		int receiptId = receiptDao.addReceiptReturnId(receiptData);
		List<Record> records = receiptForm.getRecords();
		for (Record record : records) {
			record.setReceiptId(receiptId);
			Map<String, Object> recordData = DataUtil.parseObjectToMap(record, Record.class);
			receiptDao.addReceiptReturnId(recordData);
		}
	}
	
	public List<Receipt> queryAllReceipt(ReceiptForm form, Page page) {
		List<Receipt> list = new ArrayList<Receipt>();
		List<Object> params = new ArrayList<Object>();
		params.add(page.getStartRecord());
		params.add(page.getPageRecord());
		List<Map<String, Object>> datas = receiptDao.queryAllReceipt(params);
		for (Map<String, Object> data : datas) {
			Receipt receipt = (Receipt) DataUtil.parseMapToObject(data, Receipt.class);
			list.add(receipt);
		}
		return list;
	}
}
