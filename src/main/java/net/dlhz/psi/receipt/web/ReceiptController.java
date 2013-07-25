package net.dlhz.psi.receipt.web;

import java.util.List;

import net.dlhz.core.base.entity.Page;
import net.dlhz.psi.receipt.entity.Receipt;
import net.dlhz.psi.receipt.entity.form.ReceiptForm;
import net.dlhz.psi.receipt.service.ReceiptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/receipt")
public class ReceiptController {

	@Autowired
	private ReceiptService receiptService;

	@RequestMapping("/add")
	public String add(ReceiptForm receiptForm) {
		receiptService.addReceipt(receiptForm);
		return "";
	}

	@RequestMapping("/all/list")
	public String queryAllReceipt(ModelMap map, ReceiptForm form, Page page) {
		List<Receipt> list = receiptService.queryAllReceipt(form, page);
		map.put("receiptList", list);
		return "receipt/receiptlist";
	}
}
