package com.vsoft.customer.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vsoft.core.util.SessionUtil;
import com.vsoft.customer.organization.entity.Company;
import com.vsoft.customer.organization.entity.Organization;
import com.vsoft.customer.service.CustomerService;
import com.vsoft.customer.user.entity.User;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/register/init")
	public String initRegister(HttpServletRequest request, Organization organization, Company company, User user) {
		user = customerService.register(organization, company, user);
		return login(request, user);
	}

	@RequestMapping("/register")
	public String register(HttpServletRequest request, User user) {
		user = customerService.register(user);
		return login(request, user);
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, User user) {
		boolean result = false;
		if (user.getId() == 0) {
			user = customerService.login(user);
		}
		if (user.getId() != 0) {
			String sessionId = request.getSession().getId();
			result = SessionUtil.putSession(sessionId, user);
		}
		if (result) {
			return "redirect:index";
		}
		return "";
	}

	@RequestMapping("/home")
	public String home() {
		return "pss/home";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "pss/index";
	}
	
	@RequestMapping("/head")
	public String head() {
		return "pss/head";
	}
	
	@RequestMapping("/menu")
	public String menu() {
		return "pss/menu";
	}
}
