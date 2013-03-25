package com.vsoft.pss.relationship.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsoft.core.util.DataUtil;
import com.vsoft.pss.relationship.dao.ContactsDao;
import com.vsoft.pss.relationship.entity.Contacts;

@Service
public class ContactsService {

	@Autowired
	private ContactsDao contactsDao;
	
	public void addContacts(Contacts contacts) {
		Map<String, Object> data = DataUtil.parseObjectToMap(contacts, Contacts.class);
		contactsDao.addContacts(data);
	}
}
