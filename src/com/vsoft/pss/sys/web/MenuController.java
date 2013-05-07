package com.vsoft.pss.sys.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vsoft.core.base.entity.Page;
import com.vsoft.pss.sys.entity.Menu;
import com.vsoft.pss.sys.entity.form.MenuFrom;
import com.vsoft.pss.sys.service.MenuService;

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

	@RequestMapping("/list")
	public String queryAllMenu(ModelMap map, Page page) {
		if (null == page) {
			page = new Page();
		}
		menuService.buildPage(page);
		List<MenuFrom> list = menuService.queryAllMenu(page);
		map.put("MenuList", list);
		return "pss/sys/menulist";
	}
	
	@ResponseBody
	@RequestMapping("/del")
	public String deleteMenu(@RequestParam String idStr) {
		return String.valueOf(menuService.deleteMenu(idStr));
	}
}
