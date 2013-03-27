package com.vsoft.pss.inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsoft.core.util.DataUtil;
import com.vsoft.pss.inventory.dao.SortDao;
import com.vsoft.pss.inventory.entity.Sort;
import com.vsoft.pss.inventory.entity.form.SortForm;

@Service
public class SortService {

	@Autowired
	private SortDao sortDao;
	
	public void addSort(Sort sort) {
		Map<String, Object> data = DataUtil.parseObjectToMap(sort, Sort.class);
		sortDao.addSort(data);
	}
	
	public List<SortForm> queryAllSort() {
		List<SortForm> list = new ArrayList<SortForm>();
		List<Object> params = new ArrayList<Object>();
		params.add(1);
		List<Map<String, Object>> datas = sortDao.queryAllSort(params);
		for (Map<String, Object> data : datas) {
			SortForm sort = (SortForm) DataUtil.parseMapToObject(data, SortForm.class);
			list.add(sort);
		}
		return list;
	}
}
