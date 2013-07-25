package net.dlhz.pss.relation.service;

import java.util.Map;

import net.dlhz.core.util.DataUtil;
import net.dlhz.pss.relation.dao.RelationDao;
import net.dlhz.pss.relation.entity.Relation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RelationService {

	@Autowired
	private RelationDao relationDao;
	
	public void addContacts(Relation contacts) {
		Map<String, Object> data = DataUtil.parseObjectToMap(contacts, Relation.class);
		relationDao.addContacts(data);
	}
}
