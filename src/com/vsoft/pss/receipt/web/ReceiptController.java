package com.vsoft.pss.receipt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vsoft.pss.receipt.entity.form.ReceiptForm;
import com.vsoft.pss.receipt.service.ReceiptService;

@Controller
@RequestMapping("/pss/receipt")
public class ReceiptController {

	@Autowired
	private ReceiptService receiptService;

	@RequestMapping("/add")
	public String add(ReceiptForm receiptForm) {
		receiptService.addReceipt(receiptForm);
		return "";
	}
}
