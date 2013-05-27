package com.vsoft.pss.inventory.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	/**
	 * 新增类目
	 * 
	 * @param sort
	 * @return
	 */
	public boolean addSort(Sort sort) {
		Map<String, Object> data = DataUtil.parseObjectToMap(sort, Sort.class);
		if (sort.getId() == 0) {
			String pinYinStr = DataUtil.toPinYinStr(sort.getName().substring(0, 1));
			data.put("code", pinYinStr.toUpperCase().substring(0, 1));
			List<Object> params = new ArrayList<Object>();
			params.add(true);
			params.add(sort.getParentId());
			sortDao.updateHasChild(params);
			return sortDao.addSort(data);
		} else {
			return sortDao.updateSort(data);
		}
	}

	/**
	 * 新增类目并返回
	 * 
	 * @param sort
	 * @return
	 */
	public Sort addSortReturn(Sort sort) {
		Map<String, Object> data = DataUtil.parseObjectToMap(sort, Sort.class);
		data = sortDao.addSortAndReturn(data);
		sort = (Sort) DataUtil.parseMapToObject(data, Sort.class);
		return sort;
	}

	/**
	 * 获取下级类目或品牌和商品
	 * 
	 * @param id
	 * @param role
	 * @return
	 */
	public List<SortForm> queryChild(String id, String role) {
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

	/**
	 * 查询初级类目
	 * 
	 * @return
	 */
	public List<SortForm> queryMainSort() {
		List<SortForm> list = new ArrayList<SortForm>();
		List<Map<String, Object>> datas = sortDao.queryPrimarySort();
		Map<Integer, SortForm> tempMap = new HashMap<Integer, SortForm>();
		SortForm sortForm = null;
		for (Map<String, Object> data : datas) {
			Sort sort = (Sort) DataUtil.parseMapToObject(data, Sort.class);
			if (sort.isMain() && 0 == sort.getParentId()) {
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

	/**
	 * 获取类目下的子类目
	 * 
	 * @param id
	 * @param tempMap
	 * @param params
	 * @param list
	 */
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

	/**
	 * 获取类目下的品牌
	 * 
	 * @param id
	 * @param tempMap
	 * @param params
	 * @param list
	 */
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

	/**
	 * 获取类目或品牌下的商品
	 * 
	 * @param id
	 * @param tempMap
	 * @param params
	 * @param list
	 */
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

	/**
	 * 编辑类目信息
	 * 
	 * @param id
	 * @param name
	 * @param parentId
	 * @param primary
	 * @return
	 */
	public boolean editSort(String id, String name, String parentId, String main) {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		if(!DataUtil.isEmptyStr(id)){
			data.put("id", id);
		}
		if(!DataUtil.isEmptyStr(name)){
			data.put("name", name);
		}
		if(!DataUtil.isEmptyStr(parentId)){
			Map<String, Object> countData = new LinkedHashMap<String, Object>();
			data.put("parentId", parentId);
			countData.put("parentId", parentId);
			int count = sortDao.countSort(countData); // 统计是否有子类目
			if(count > 0){
				data.put("hasChild", true);
			}else{
				data.put("hasChild", false);
			}
		}
		if(!DataUtil.isEmptyStr(main)){
			if("true".equals(main)){
				data.put("main", true);
			}else{
				data.put("main", false);
			}
		}
		if(data.size() < 1){
			return false;
		}
		return sortDao.updateSort(data);
	}
	
	public boolean deleteSort(String idStr) {
		return sortDao.deleteSort(idStr);
	}
	
}
