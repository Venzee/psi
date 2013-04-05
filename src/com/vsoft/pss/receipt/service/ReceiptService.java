package com.vsoft.pss.receipt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
