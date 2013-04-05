package com.vsoft.pss.inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsoft.core.base.entity.Page;
import com.vsoft.core.util.DataUtil;
import com.vsoft.pss.inventory.dao.BrandDao;
import com.vsoft.pss.inventory.entity.Brand;

@Service
public class BrandService {

	@Autowired
	private BrandDao brandDao;

	public boolean addBrand(Brand brand) {
		Map<String, Object> data = DataUtil.parseObjectToMap(brand, Brand.class);
		return brandDao.addBrand(data);
	}

	public List<Brand> queryAllBrand(Page page) {
		List<Brand> list = new ArrayList<Brand>();
		List<Object> params = new ArrayList<Object>();
		params.add(page.getStartRecord());
		params.add(page.getPageRecord());
		List<Map<String, Object>> datas = brandDao.queryAllBrand(params);
		for (Map<String, Object> data : datas) {
			Brand brand = (Brand) DataUtil.parseMapToObject(data, Brand.class);
			list.add(brand);
		}
		return list;
	}
	
	public List<Brand> queryBrandByIndustry(Brand form) {
		List<Brand> list = new ArrayList<Brand>();
		List<Object> params = new ArrayList<Object>();
		params.add(form.getCreatCompanyId());
		params.add(form.getIndustryId());
		List<Map<String, Object>> datas = brandDao.queryAllBrand(params);
		for (Map<String, Object> data : datas) {
			Brand brand = (Brand) DataUtil.parseMapToObject(data, Brand.class);
			list.add(brand);
		}
		return list;
	}
	
	public void buildPage(Page page) {
		int count = brandDao.countBrandById();
		page.init(count);
	}
}
