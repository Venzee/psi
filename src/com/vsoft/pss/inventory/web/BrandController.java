package com.vsoft.pss.inventory.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vsoft.core.base.entity.Page;
import com.vsoft.pss.inventory.entity.Brand;
import com.vsoft.pss.inventory.entity.form.BrandFrom;
import com.vsoft.pss.inventory.service.BrandService;

@Controller
@RequestMapping("/pss/inventory/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;

	@ResponseBody
	@RequestMapping("/add")
	public String addBrand(Brand brand) {
		return String.valueOf(brandService.addBrand(brand));
	}

	@RequestMapping("/list")
	public String queryAllBrand(ModelMap map, Page page) {
		if (null == page) {
			page = new Page();
		}
		brandService.buildPage(page);
		List<BrandFrom> list = brandService.queryAllBrand(page);
		map.put("brandList", list);
		return "pss/inventory/brandlist";
	}
}
