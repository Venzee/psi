package com.vsoft.pss.organization.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vsoft.pss.organization.entity.Industry;
import com.vsoft.pss.organization.service.IndustryService;
import com.vsoft.pss.organization.service.OrganizationService;

@Controller
@RequestMapping("/orga")
public class OrganizationController {

	@Autowired
	IndustryService industryService;
	
	@Autowired
	OrganizationService organizationService;
	
	@RequestMapping("/indus/add")
	public String add(Industry industry, ModelMap map) {
		industryService.addIndustry(industry);
		return "";
	}
	
	@RequestMapping("/indus/qa")
	public String queryAll(ModelMap map) {
		List<Industry> list = industryService.queryAllIndustry();
		map.put("industryList", list);
		return "";
	}
}
