package net.dlhz.psi.receipt.service;

import net.dlhz.psi.receipt.dao.ReceiptDao;
import net.dlhz.psi.receipt.dao.RecordDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReceiptService {

	@Autowired
	private ReceiptDao receiptDao;

	@Autowired
	private RecordDao recordDao;

}
