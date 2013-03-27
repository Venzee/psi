package com.vsoft.pss.inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsoft.core.util.DataUtil;
import com.vsoft.pss.inventory.dao.SortDao;
import com.vsoft.pss.inventory.entity.Sort;

@Service
public class SortService {

	@Autowired
	private SortDao sortDao;
	
	public void addSort(Sort sort) {
		Map<String, Object> data = DataUtil.parseObjectToMap(sort, Sort.class);
		sortDao.addSort(data);
	}
	
	public List<Sort> queryAllSort() {
		List<Sort> list = new ArrayList<Sort>();
		List<Object> params = new ArrayList<Object>();
		List<Map<String, Object>> datas = sortDao.queryAllSort(params);
		if(datas != null && datas.size() > 0){
			for (Map<String, Object> data : datas) {
				Sort sort = (Sort) DataUtil.parseMapToObject(data, Sort.class);
				list.add(sort);
			}
		}
		
		return list;
	}
}
