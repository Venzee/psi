package com.vsoft.pss.inventory.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.vsoft.pss.inventory.entity.Sort;
import com.vsoft.pss.inventory.entity.form.SortForm;
import com.vsoft.pss.inventory.service.SortService;

@Controller
@RequestMapping("/inventory/sort")
public class SortController {

	@Autowired
	private SortService sortService;

	@ResponseBody
	@RequestMapping("/add")
	public String addSort(Sort sort) {
		return String.valueOf(sortService.addSort(sort));
	}
	
	@ResponseBody
	@RequestMapping(value = "/addre", produces = "application/json;charset=utf-8")
	public String addSortReturn(Sort sort) {
		return JSON.toJSONString(sortService.addSortReturn(sort));
	}
	
	@ResponseBody
	@RequestMapping(value = "/childlist", produces = "application/json;charset=utf-8")
	public String querySort(String parentId, String role) {
		return JSON.toJSONString(sortService.queryChild(parentId, role));
	}

	@RequestMapping("/list")
	public String querySort(ModelMap map) {
		List<SortForm> list = sortService.queryPrimarySort();
		map.put("sortList", list);
		return "inventory/sortlist";
	}
	
	@ResponseBody
	@RequestMapping(value = "/ajaxlist", produces = "application/json;charset=utf-8")
	public String querySort() {
		List<SortForm> list = sortService.queryPrimarySort();
		return JSON.toJSONString(list);
	}
	
	@ResponseBody
	@RequestMapping("/edit")
	public String editSort(String id, String name, String parentId, String primary) {
		return String.valueOf(sortService.editSort(id, name, parentId, primary));
	}
	
	@ResponseBody
	@RequestMapping("/del")
	public String deleteSort(String idStr) {
		return String.valueOf(sortService.deleteSort(idStr));
	}
}
