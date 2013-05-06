package com.vsoft.pss.organization.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.vsoft.pss.organization.service.OrganizationService;

@Controller
@RequestMapping("/org/pss")
public class OrganizationController {

	@Autowired
	OrganizationService organizationService;
	
}
