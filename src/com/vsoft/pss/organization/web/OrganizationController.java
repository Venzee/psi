package com.vsoft.pss.organization.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vsoft.core.base.entity.Page;
import com.vsoft.pss.organization.entity.Organization;
import com.vsoft.pss.organization.service.OrganizationService;
import com.vsoft.pss.receipt.entity.form.ReceiptForm;

@Controller
@RequestMapping("/org")
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;
	
	@RequestMapping("/all/list")
	public String queryAllOrg(ModelMap map, ReceiptForm form, Page page) {
		List<Organization> list = organizationService.queryAllOrg(form, page);
		map.put("organizationList", list);
		return "pss/organization/organizationlist";
	}
}
