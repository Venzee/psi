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
import com.vsoft.pss.inventory.entity.Goods;
import com.vsoft.pss.inventory.entity.form.GoodsForm;
import com.vsoft.pss.inventory.service.GoodsService;

@Controller
@RequestMapping("/inventory/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	@ResponseBody
	@RequestMapping("/add")
	public String addGoods(Goods goods) {
		return String.valueOf(goodsService.addGoods(goods)); 
	}
	
	@RequestMapping("/list")
	public String queryAllGoods(ModelMap map, Page page, GoodsForm GoodsForm) {
		if (page == null) {
			page = new Page();
		}
		if (GoodsForm == null) {
			GoodsForm = new GoodsForm();
		}
		goodsService.buildPage(page);
		List<GoodsForm> list = goodsService.queryAllGoods(page);
		map.put("page", page);
		map.put("goodsList", list);
		return "inventory/goods";
	}
	
	@ResponseBody
	@RequestMapping(value = "/info", produces = "text/html;charset=UTF-8")
	public String queryOneGoods(@RequestParam String id) {
		Goods Goods = goodsService.queryOneGoods(id);
		return JSON.toJSONString(Goods);
	}

	@ResponseBody
	@RequestMapping("/del")
	public String deleteGoods(@RequestParam String id) {
		return String.valueOf(goodsService.deleteGoods(id));
	}
}
