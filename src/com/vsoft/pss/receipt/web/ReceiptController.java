package com.vsoft.pss.receipt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vsoft.core.base.entity.Page;
import com.vsoft.pss.receipt.entity.Receipt;
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

	@RequestMapping("/list")
	public String queryAllReceipt(ModelMap map, ReceiptForm form, Page page) {
		List<Receipt> list = receiptService.queryAllReceipt(form, page);
		map.put("receiptList", list);
		return "pss/receipt/receipt";
	}
}
