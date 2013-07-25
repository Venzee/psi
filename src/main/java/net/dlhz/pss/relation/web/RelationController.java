package net.dlhz.pss.relation.web;

import net.dlhz.pss.relation.entity.Relation;
import net.dlhz.pss.relation.service.RelationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


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
