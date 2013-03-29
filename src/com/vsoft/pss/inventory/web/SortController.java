package com.vsoft.pss.inventory.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vsoft.core.base.entity.Page;
import com.vsoft.pss.inventory.entity.Sort;
import com.vsoft.pss.inventory.entity.form.SortForm;
import com.vsoft.pss.inventory.service.SortService;

@Controller
@RequestMapping("/inventory/sort")
public class SortController {

	@Autowired
	private SortService sortService;
	private Page page;
	
	@RequestMapping("/add")
	public String addSort(Sort sort) {
		sortService.addSort(sort);
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String queryAllSort(ModelMap map) {
		if(page == null){
			page = new Page();
		}
		sortService.buildPage(page);
		List<SortForm> list = sortService.queryAllSort(page);
		map.put("page", page);
		map.put("sortList", list);
		return "inventory/sort";
	}
}
