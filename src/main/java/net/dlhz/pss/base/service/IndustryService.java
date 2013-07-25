package net.dlhz.pss.base.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.dlhz.core.util.DataUtil;
import net.dlhz.pss.base.dao.IndustryDao;
import net.dlhz.pss.base.entity.Industry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IndustryService {

	@Autowired
	private IndustryDao industryDao;

	public boolean addIndustry(Industry industry) {
		Map<String, Object> data = DataUtil.parseObjectToMap(industry, Industry.class);
		return industryDao.addIndustry(data);
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

	public List<Industry> queryAllIndustryWithoutDescription() {
		List<Industry> list = new ArrayList<Industry>();
		List<Object> params = new ArrayList<Object>();
		List<Map<String, Object>> data = industryDao.queryAllIndustryWithoutDescription(params);
		for (Map<String, Object> map : data) {
			Industry industry = (Industry) DataUtil.parseMapToObject(map, Industry.class);
			list.add(industry);
		}
		return list;
	}

	public boolean deleteIndustry(String idStr) {
		return industryDao.deleteIndustry(idStr);
	}
}
