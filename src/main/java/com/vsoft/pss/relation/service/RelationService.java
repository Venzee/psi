package com.vsoft.pss.relation.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsoft.core.util.DataUtil;
import com.vsoft.pss.relation.dao.RelationDao;
import com.vsoft.pss.relation.entity.Relation;

@Service
public class RelationService {

	@Autowired
	private RelationDao relationDao;
	
	public void addContacts(Relation contacts) {
		Map<String, Object> data = DataUtil.parseObjectToMap(contacts, Relation.class);
		relationDao.addContacts(data);
	}
}
