package net.dlhz.pss.receipt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.dlhz.core.base.entity.Page;
import net.dlhz.core.util.DataUtil;
import net.dlhz.pss.receipt.dao.ReceiptDao;
import net.dlhz.pss.receipt.dao.RecordDao;
import net.dlhz.pss.receipt.entity.Receipt;
import net.dlhz.pss.receipt.entity.Record;
import net.dlhz.pss.receipt.entity.form.ReceiptForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
