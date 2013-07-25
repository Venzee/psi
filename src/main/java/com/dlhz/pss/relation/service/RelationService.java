package com.dlhz.pss.relation.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlhz.core.util.DataUtil;
import com.dlhz.pss.relation.dao.RelationDao;
import com.dlhz.pss.relation.entity.Relation;

@Service
public class RelationService {

	@Autowired
	private RelationDao relationDao;
	
	public void addContacts(Relation contacts) {
		Map<String, Object> data = DataUtil.parseObjectToMap(contacts, Relation.class);
		relationDao.addContacts(data);
	}
}
