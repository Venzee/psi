package com.dlhz.pss.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlhz.pss.sys.entity.Menu;
import com.dlhz.pss.sys.service.MenuService;

@Controller
@RequestMapping("/sys/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@ResponseBody
	@RequestMapping("/add")
	public String addMenu(Menu menu) {
		return String.valueOf(menuService.addMenu(menu));
	}
	
	@ResponseBody
	@RequestMapping("/del")
	public String deleteMenu(@RequestParam String idStr) {
		return String.valueOf(menuService.deleteMenu(idStr));
	}
}
