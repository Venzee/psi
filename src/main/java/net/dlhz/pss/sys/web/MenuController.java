package net.dlhz.pss.sys.web;

import net.dlhz.pss.sys.entity.Menu;
import net.dlhz.pss.sys.service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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
