package com.vsoft.pss.inventory.service;

import java.util.ArrayList;
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
import com.vsoft.pss.inventory.entity.Goods;
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
		String pinYinStr = DataUtil.toPinYinStr(sort.getName().substring(0, 1));
		data.put("code", pinYinStr.toUpperCase().substring(0, 1));
		data = sortDao.addSortAndReturn(data);
		sort = (Sort) DataUtil.parseMapToObject(data, Sort.class);
		return sort;
	}

	/**
	 * 获取下级类目或品牌和商品
	 * 
	 * @param id
	 * @return
	 */
	public List<SortForm> querySort(String id) {
		List<SortForm> list = new ArrayList<SortForm>();
		Map<String, Object> params = new LinkedHashMap<String, Object>();
		this.getSort(id, params, list);
		if (list.size() < 1) {
			this.getBrand(id, params, list);
			if (list.size() < 1) {
				this.getGoods(id, params, list);
			}
		}
		return list;
	}

	/**
	 * 获取类目下的子类目
	 * 
	 * @param id
	 * @param params
	 * @param list
	 */
	private void getSort(String id, Map<String, Object> params, List<SortForm> list) {
		params.clear();
		params.put("id", id);
		int count = sortDao.countSort(params);
		if (count > 0) {
			SortForm sortForm = null;
			List<Map<String, Object>> datas = sortDao.querySort(id);
			for (Map<String, Object> data : datas) {
				Sort sort = (Sort) DataUtil.parseMapToObject(data, Sort.class);
				sortForm = new SortForm();
				sortForm.setRole("sort");
				sortForm.setObject(sort);
				list.add(sortForm);
			}
		}
	}

	/**
	 * 获取类目下的品牌
	 * 
	 * @param id
	 * @param params
	 * @param list
	 */
	private void getBrand(String id, Map<String, Object> params, List<SortForm> list) {
		params.clear();
		params.put("sortId", id);
		params.put("status", 0);
		int count = brandDao.countBrand(params);
		if (count > 0) {
			SortForm sortForm = null;
			List<Map<String, Object>> datas = brandDao.queryBrandBySort(id);
			for (Map<String, Object> data : datas) {
				Brand brand = (Brand) DataUtil.parseMapToObject(data, Brand.class);
				sortForm = new SortForm();
				sortForm.setRole("sort");
				sortForm.setObject(brand);
				list.add(sortForm);
			}
		}
	}

	/**
	 * 获取类目或品牌下的商品
	 * 
	 * @param id
	 * @param params
	 * @param list
	 */
	private void getGoods(String id, Map<String, Object> params, List<SortForm> list) {
		params.clear();
		params.put("brandId", id);
		params.put("status", 0);
		int count = goodsDao.countGoods(params);
		SortForm sortForm = null;
		List<Map<String, Object>> datas = null;
		if (count > 0) {
			datas = goodsDao.queryGoodsByBrand(id);
		} else {
			params.clear();
			params.put("sortId", id);
			params.put("status", 0);
			count = goodsDao.countGoods(params);
			if (count > 0) {
				datas = goodsDao.queryGoodsBySort(id);
			}
		}
		if(null != datas){
			for (Map<String, Object> data : datas) {
				Goods goods = (Goods) DataUtil.parseMapToObject(data, Goods.class);
				sortForm = new SortForm();
				sortForm.setRole("goods");
				sortForm.setObject(goods);
				list.add(sortForm);
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
