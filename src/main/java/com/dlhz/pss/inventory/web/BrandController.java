package com.dlhz.pss.inventory.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlhz.core.base.entity.Page;
import com.dlhz.pss.inventory.entity.Brand;
import com.dlhz.pss.inventory.entity.form.BrandFrom;
import com.dlhz.pss.inventory.service.BrandService;

@Controller
@RequestMapping("/inventory/brand")
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
		return "inventory/brandlist";
	}
	
	@ResponseBody
	@RequestMapping("/del")
	public String deleteBrand(@RequestParam String idStr) {
		return String.valueOf(brandService.deleteBrand(idStr));
	}
}
