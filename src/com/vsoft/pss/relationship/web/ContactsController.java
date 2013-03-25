package com.vsoft.pss.relationship.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vsoft.pss.relationship.entity.Contacts;
import com.vsoft.pss.relationship.service.ContactsService;

@Controller
@RequestMapping("/relation")
public class ContactsController {

	@Autowired
	private ContactsService contactsService;

	@RequestMapping("/add")
	public String add(Contacts contacts) {
		contactsService.addContacts(contacts);
		return "";
	}
}
