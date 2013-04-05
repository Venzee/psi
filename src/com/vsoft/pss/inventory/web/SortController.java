package com.vsoft.pss.inventory.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.vsoft.core.base.entity.Page;
import com.vsoft.pss.inventory.entity.Sort;
import com.vsoft.pss.inventory.entity.form.SortForm;
import com.vsoft.pss.inventory.service.SortService;

@Controller
@RequestMapping("/pss/inventory/sort")
public class SortController {

	@Autowired
	private SortService sortService;

	@ResponseBody
	@RequestMapping("/add")
	public String addSort(Sort sort) {
		return String.valueOf(sortService.addSort(sort));
	}

	@RequestMapping("/list")
	public String queryAllSort(ModelMap map, Page page, SortForm sortForm) {
		if (page == null) {
			page = new Page();
		}
		if (sortForm == null) {
			sortForm = new SortForm();
		}
		sortService.buildPage(page);
		List<SortForm> list = sortService.queryAllSort(page);
		map.put("page", page);
		map.put("sortList", list);
		return "pss/inventory/sort";
	}
	
	@RequestMapping("/select/init")
	public String queryAllSortByTopId(ModelMap map, @RequestParam String topId) {
		if (topId == null) {
			topId = "0";
		}
		List<SortForm> list = sortService.queryAllSortByTopId(topId);
		map.put("sortList", list);
		return "pss/inventory/sort2";
	}
	
	@ResponseBody
	@RequestMapping(value = "/select", produces = "text/html;charset=UTF-8")
	public String queryAllSortByTopId(@RequestParam String topId) {
		if (topId == null) {
			topId = "0";
		}
		List<SortForm> list = sortService.queryAllSortByTopId(topId);
		return JSON.toJSONString(list);
	}

	@ResponseBody
	@RequestMapping(value = "/info", produces = "text/html;charset=UTF-8")
	public String queryOneSort(@RequestParam String id) {
		Sort sort = sortService.queryOneSort(id);
		return JSON.toJSONString(sort);
	}

	@ResponseBody
	@RequestMapping("/del")
	public String deleteSort(@RequestParam String id) {
		return String.valueOf(sortService.deleteSort(id));
	}
}
