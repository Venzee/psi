package com.vsoft.pss.inventory.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsoft.core.base.entity.Page;
import com.vsoft.core.util.DataUtil;
import com.vsoft.pss.inventory.dao.BrandDao;
import com.vsoft.pss.inventory.dao.GoodsDao;
import com.vsoft.pss.inventory.dao.SortDao;
import com.vsoft.pss.inventory.entity.Brand;
import com.vsoft.pss.inventory.entity.Sort;
import com.vsoft.pss.inventory.entity.form.SortForm;

@Service
public class SortService {

	@Autowired
	private SortDao sortDao;

	@Autowired
	private BrandDao brandDao;

	@Autowired
	private GoodsDao goodsDao;

	public boolean addSort(Sort sort) {
		Map<String, Object> data = DataUtil.parseObjectToMap(sort, Sort.class);
		if (sort.getId() == 0) {
			return sortDao.addSort(data);
		} else {
			return sortDao.updateSort(data);
		}
	}

	public Sort addSortReturn(Sort sort) {
		Map<String, Object> data = DataUtil.parseObjectToMap(sort, Sort.class);
		data = sortDao.addSortAndReturn(data);
		sort = (Sort) DataUtil.parseMapToObject(data, Sort.class);
		return sort;
	}

	public List<SortForm> querySort(Page page) {
		List<SortForm> list = new ArrayList<SortForm>();
		List<Object> params = new ArrayList<Object>();
		params.add(page.getStartRecord());
		params.add(page.getPageRecord());
		List<Map<String, Object>> datas = sortDao.querySort(params);
		for (Map<String, Object> data : datas) {
			SortForm sortForm = (SortForm) DataUtil.parseMapToObject(data, SortForm.class);
			list.add(sortForm);
		}
		return list;
	}

	public List<SortForm> querySort(String id, String role) {
		List<SortForm> list = new ArrayList<SortForm>();
		Map<String, Object> params = new LinkedHashMap<String, Object>();
		Map<String, SortForm> tempMap = new HashMap<String, SortForm>();
		if ("sort".equals(role)) {
			this.getChildSort(id, tempMap, params, list);
			if (list.size() < 1) {
				this.getChildBrand(id, tempMap, params, list);
				if (list.size() < 1) {
					this.getChildGoods(id, tempMap, params, list);
				}
			}
		}
		if ("brand".equals(role)) {
			this.getChildGoods(id, tempMap, params, list);
		}
		return list;
	}

	public List<SortForm> querySort() {
		List<SortForm> list = new ArrayList<SortForm>();
		List<Map<String, Object>> datas = sortDao.querySort();
		Map<Integer, SortForm> tempMap = new HashMap<Integer, SortForm>();
		SortForm sortForm = null;
		for (Map<String, Object> data : datas) {
			Sort sort = (Sort) DataUtil.parseMapToObject(data, Sort.class);
			if (sort.isPrimary() && 0 == sort.getParentId()) {
				sortForm = tempMap.get(sort.getId());
				if (null == sortForm) {
					sortForm = new SortForm();
					sortForm.setRole("sort");
				}
				sortForm.setSort(sort);
				tempMap.put(sort.getId(), sortForm);
			} else {
				sortForm = tempMap.get(sort.getParentId());
				if (null == sortForm) {
					sortForm = new SortForm();
					sortForm.setRole("sort");
				}
				if (null == sortForm.getChildList()) {
					sortForm.setChildList(new ArrayList<Object>());
				}
				sortForm.getChildList().add(sort);
				tempMap.put(sort.getParentId(), sortForm);
			}
		}
		list.addAll(tempMap.values());
		return list;
	}

	public boolean deleteSort(String idStr) {
		return sortDao.deleteSort(idStr);
	}

	private void getChildSort(String id, Map<String, SortForm> tempMap, Map<String, Object> params, List<SortForm> list) {
		params.clear();
		params.put("id", id);
		int count = sortDao.countSort(params);
		if (count > 0) {
			List<Map<String, Object>> datas = sortDao.querySort(id);
			for (Map<String, Object> data : datas) {
				Sort sort = (Sort) DataUtil.parseMapToObject(data, Sort.class);
				String code = sort.getCode();
				SortForm sortForm = tempMap.get(code);
				if (null == sortForm) {
					sortForm = new SortForm();
					sortForm.setCode(code);
					sortForm.setRole("sort");
				}
				if (null == sortForm.getChildList()) {
					sortForm.setChildList(new ArrayList<Object>());
				}
				sortForm.getChildList().add(sort);
				tempMap.put(code, sortForm);
			}
			list.addAll(tempMap.values());
		}
	}

	private void getChildBrand(String id, Map<String, SortForm> tempMap, Map<String, Object> params, List<SortForm> list) {
		params.clear();
		params.put("sortId", id);
		params.put("status", 0);
		int count = brandDao.countBrand(params);
		if (count > 0) {
			List<Map<String, Object>> datas = brandDao.queryBrandBySort(id);
			for (Map<String, Object> data : datas) {
				Brand brand = (Brand) DataUtil.parseMapToObject(data, Brand.class);
				String code = brand.getCode();
				SortForm sortForm = tempMap.get(code);
				if (null == sortForm) {
					sortForm = new SortForm();
					sortForm.setCode(code);
					sortForm.setRole("brand");
				}
				if (null == sortForm.getChildList()) {
					sortForm.setChildList(new ArrayList<Object>());
				}
				sortForm.getChildList().add(brand);
				tempMap.put(code, sortForm);
			}
			list.addAll(tempMap.values());
		}
	}

	private void getChildGoods(String id, Map<String, SortForm> tempMap, Map<String, Object> params, List<SortForm> list) {
		params.clear();
		params.put("brandId", id);
		params.put("status", 0);
		int count = goodsDao.countGoods(params);
		if (count > 0) {
			List<Map<String, Object>> datas = goodsDao.queryGoodsByBrand(id);
			for (Map<String, Object> data : datas) {
				Brand brand = (Brand) DataUtil.parseMapToObject(data, Brand.class);
				String code = brand.getCode();
				SortForm sortForm = tempMap.get(code);
				if (null == sortForm) {
					sortForm = new SortForm();
					sortForm.setCode(code);
					sortForm.setRole("goods");
				}
				if (null == sortForm.getChildList()) {
					sortForm.setChildList(new ArrayList<Object>());
				}
				sortForm.getChildList().add(brand);
				tempMap.put(code, sortForm);
			}
			list.addAll(tempMap.values());
		} else {
			params.clear();
			params.put("sortId", id);
			params.put("status", 0);
			count = goodsDao.countGoods(params);
			if (count > 0) {
				List<Map<String, Object>> datas = goodsDao.queryGoodsBySort(id);
				for (Map<String, Object> data : datas) {
					Brand brand = (Brand) DataUtil.parseMapToObject(data, Brand.class);
					String code = brand.getCode();
					SortForm sortForm = tempMap.get(code);
					if (null == sortForm) {
						sortForm = new SortForm();
						sortForm.setCode(code);
						sortForm.setRole("goods");
					}
					if (null == sortForm.getChildList()) {
						sortForm.setChildList(new ArrayList<Object>());
					}
					sortForm.getChildList().add(brand);
					tempMap.put(code, sortForm);
				}
				list.addAll(tempMap.values());
			}
		}
	}
}
