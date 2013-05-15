package com.vsoft.pss.inventory.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsoft.core.base.entity.Page;
import com.vsoft.core.util.DataUtil;
import com.vsoft.pss.inventory.dao.SortDao;
import com.vsoft.pss.inventory.entity.Sort;
import com.vsoft.pss.inventory.entity.form.SortForm;

@Service
public class SortService {

	@Autowired
	private SortDao sortDao;

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

	public Object querySort(String parentId) {
		List<Sort> list = new ArrayList<Sort>();
		List<Map<String, Object>> datas = sortDao.querySort(parentId);
		for (Map<String, Object> data : datas) {
			Sort sort = (Sort) DataUtil.parseMapToObject(data, Sort.class);
			list.add(sort);
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
			if (0 == sort.getLevel()) {
				sortForm = tempMap.get(sort.getId());
				if (null == sortForm) {
					sortForm = new SortForm();
				}
				sortForm.setSort(sort);
				tempMap.put(sort.getId(), sortForm);
			} else {
				sortForm = tempMap.get(sort.getId());
				if (null == sortForm) {
					sortForm = new SortForm();
				}
				if (null == sortForm.getChildList()) {
					sortForm.setChildList(new ArrayList<Sort>());
				}
				sortForm.getChildList().add(sort);
				tempMap.put(sort.getParentId(), sortForm);
			}
			list.addAll(tempMap.values());
		}
		return list;
	}

	public boolean deleteSort(String idStr) {
		return sortDao.deleteSort(idStr);
	}

}
