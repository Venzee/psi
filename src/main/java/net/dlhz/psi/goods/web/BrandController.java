package net.dlhz.psi.goods.web;

import java.util.List;

import net.dlhz.core.base.entity.Page;
import net.dlhz.psi.goods.entity.Brand;
import net.dlhz.psi.goods.service.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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
		List<Brand> list = brandService.queryBrand(page);
		map.put("brandList", list);
		return "inventory/brandlist";
	}
	
	@ResponseBody
	@RequestMapping("/del")
	public String deleteBrand(@RequestParam String idStr) {
		return String.valueOf(brandService.deleteBrand(idStr));
	}
}
