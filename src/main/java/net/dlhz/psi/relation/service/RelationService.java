package net.dlhz.psi.relation.service;

import java.util.Map;

import net.dlhz.core.util.DataUtil;
import net.dlhz.psi.relation.dao.RelationDao;
import net.dlhz.psi.relation.entity.Relation;

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
