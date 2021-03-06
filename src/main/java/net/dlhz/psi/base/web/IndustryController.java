package net.dlhz.psi.base.web;

import java.util.List;

import net.dlhz.psi.base.entity.Industry;
import net.dlhz.psi.base.service.IndustryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/org/industry")
public class IndustryController {

	@Autowired
	private IndustryService industryService;
	
	@ResponseBody
	@RequestMapping("/add")
	public String addindustry(Industry industry) {
		return String.valueOf(industryService.addIndustry(industry));
	}
	
	@ResponseBody
	@RequestMapping(value = "/ajaxlist", produces = "text/html;charset=UTF-8")
	public String queryAllIndustry() {
		List<Industry> list = industryService.queryAllIndustryWithoutDescription();
		return JSON.toJSONString(list);
	}
	
	@ResponseBody
	@RequestMapping("/del")
	public String deleteIndustry(@RequestParam String idStr) {
		return String.valueOf(industryService.deleteIndustry(idStr));
	}
	
	@RequestMapping("/list")
	public String queryAllIndustry(ModelMap map) {
		List<Industry> list = industryService.queryAllIndustry();
		map.put("industryList", list);
		return "organization/industrylist";
	}
}
