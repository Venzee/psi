package com.vsoft.pss.inventory.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vsoft.pss.inventory.entity.Sort;
import com.vsoft.pss.inventory.service.SortService;

@Controller
@RequestMapping("/inventory/sort")
public class SortController {

	@Autowired
	private SortService sortService;
	
	@RequestMapping("/add")
	public String addSort(Sort sort) {
		sortService.addSort(sort);
		return "inventory/sort";
	}
	
	@RequestMapping("/list")
	public String queryAllSort(ModelMap map) {
		List<Sort> list = sortService.queryAllSort();
		map.put("sortList", list);
		return "inventory/sort";
	}
}
