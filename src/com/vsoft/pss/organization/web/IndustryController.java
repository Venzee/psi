package com.vsoft.pss.organization.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vsoft.pss.organization.entity.Industry;
import com.vsoft.pss.organization.service.IndustryService;

@Controller
@RequestMapping("/organization/industry")
public class IndustryController {

	@Autowired
	private IndustryService industryService;
	
	@ResponseBody
	@RequestMapping("/add")
	public String addindustry(Industry industry) {
		return String.valueOf(industryService.addIndustry(industry));
	}
	
	@RequestMapping("/list")
	public String queryAllIndustry(ModelMap map) {
		List<Industry> list = industryService.queryAllIndustry();
		map.put("industryList", list);
		return "pss/organization/industrylist";
	}
}
