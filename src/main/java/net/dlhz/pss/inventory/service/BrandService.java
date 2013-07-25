package net.dlhz.pss.inventory.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.dlhz.core.base.entity.Page;
import net.dlhz.core.util.DataUtil;
import net.dlhz.pss.inventory.dao.BrandDao;
import net.dlhz.pss.inventory.entity.Brand;
import net.dlhz.pss.inventory.entity.form.BrandFrom;

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

	public List<BrandFrom> queryAllBrand(Page page) {
		List<BrandFrom> list = new ArrayList<BrandFrom>();
		List<Object> params = new ArrayList<Object>();
		params.add(page.getStartRecord());
		params.add(page.getPageRecord());
		List<Map<String, Object>> datas = brandDao.queryAllBrand(params);
		for (Map<String, Object> data : datas) {
			BrandFrom brandFrom = (BrandFrom) DataUtil.parseMapToObject(data, BrandFrom.class);
			list.add(brandFrom);
		}
		return list;
	}
	
	public List<Brand> queryBrandByIndustry(Brand form) {
		List<Brand> list = new ArrayList<Brand>();
		List<Object> params = new ArrayList<Object>();
		params.add(form.getCompanyId());
		params.add(form.getSortId());
		List<Map<String, Object>> datas = brandDao.queryAllBrand(params);
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
