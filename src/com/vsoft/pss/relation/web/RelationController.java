package com.vsoft.pss.relation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vsoft.pss.relation.entity.Relation;
import com.vsoft.pss.relation.service.RelationService;

@Controller
@RequestMapping("/relation")
public class RelationController {

	@Autowired
	private RelationService contactsService;

	@RequestMapping("/add")
	public String add(Relation contacts) {
		contactsService.addContacts(contacts);
		return "";
	}
}
