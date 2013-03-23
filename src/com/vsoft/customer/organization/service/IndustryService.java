package com.vsoft.customer.organization.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsoft.core.util.DataUtil;
import com.vsoft.customer.organization.dao.IndustryDao;
import com.vsoft.customer.organization.entity.Industry;

@Service
public class IndustryService {

	@Autowired
	private IndustryDao industryDao;

	public void addIndustry(Industry industry) {
		Map<String, Object> data = DataUtil.parseObjectToMap(industry, Industry.class);
		industryDao.addIndustry(data);
	}

	public List<Industry> queryAllIndustry() {
		List<Industry> list = new ArrayList<Industry>();
		List<Object> params = new ArrayList<Object>();
		List<Map<String, Object>> data = industryDao.queryAllIndustry(params);
		for (Map<String, Object> map : data) {
			Industry industry = (Industry) DataUtil.parseMapToObject(map, Industry.class);
			list.add(industry);
		}
		return list;
	}
}
