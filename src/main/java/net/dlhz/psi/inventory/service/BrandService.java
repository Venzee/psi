package net.dlhz.psi.inventory.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.dlhz.core.base.entity.Page;
import net.dlhz.core.util.DataUtil;
import net.dlhz.psi.inventory.dao.BrandDao;
import net.dlhz.psi.inventory.entity.Brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BrandService {

	@Autowired
	private BrandDao brandDao;

	public boolean addBrand(Brand brand) {
		Map<String, Object> data = DataUtil.parseObjectToMap(brand, Brand.class);
		return brandDao.addBrand(data);
	}

	public List<Brand> queryBrand(Page page) {
		List<Brand> list = new ArrayList<Brand>();
		List<Object> params = new ArrayList<Object>();
		params.add(page.getStartRecord());
		params.add(page.getPageRecord());
		List<Map<String, Object>> datas = brandDao.queryBrand(params);
		for (Map<String, Object> data : datas) {
			Brand brand = (Brand) DataUtil.parseMapToObject(data, Brand.class);
			list.add(brand);
		}
		return list;
	}
	
	public List<Brand> queryBrandByIndustry(Brand form) {
		List<Brand> list = new ArrayList<Brand>();
		List<Object> params = new ArrayList<Object>();
		params.add(form.getCompanyId());
		params.add(form.getSortId());
		List<Map<String, Object>> datas = brandDao.queryBrand(params);
		for (Map<String, Object> data : datas) {
			Brand brand = (Brand) DataUtil.parseMapToObject(data, Brand.class);
			list.add(brand);
		}
		return list;
	}
	
	public void buildPage(Page page) {
		Map<String, Object> params = new LinkedHashMap<String, Object>();
		int count = brandDao.countBrand(params);
		page.init(count);
	}

	public boolean deleteBrand(String idStr) {
		return brandDao.deleteBrand(idStr);
	}
}
