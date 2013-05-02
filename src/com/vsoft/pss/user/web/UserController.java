package com.vsoft.pss.user.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vsoft.core.base.entity.SessionUser;
import com.vsoft.core.util.SessionUtil;
import com.vsoft.pss.organization.entity.Company;
import com.vsoft.pss.organization.entity.Organization;
import com.vsoft.pss.user.entity.User;
import com.vsoft.pss.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/register/init")
	public String initRegister(HttpServletRequest request, Organization organization, Company company, User user) {
		user = userService.register(organization, company, user);
		return login(request, user);
	}

	@RequestMapping("/register")
	public String register(HttpServletRequest request, User user, ModelMap map) {
		if ("".equals(user.getUsername()) || null == user.getUsername()) {
			map.put("tip", "用户名不能为空！");
			return "pss/register";
		}
		if ("".equals(user.getPassword()) || null == user.getPassword()) {
			map.put("tip", "密码不能为空！");
			return "pss/register";
		}
		user = userService.register(user);
		return login(request, user);
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, User user) {
		boolean result = false;
		SessionUser sessionUser = new SessionUser();
		String sessionId = request.getSession().getId();
		if (user.getId() == 0) {
			user = userService.login(user);
		}
		sessionUser.setUsername(user.getUsername());
		result = SessionUtil.putSession(sessionId, sessionUser);
		if (result) {
			return "redirect:index";
		}
		return "pss/login";
	}

	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		String sessionId = request.getSession().getId();
		SessionUser sessionUser = SessionUtil.getUserBySessionId(sessionId);
		if (sessionUser == null) {
			return "pss/login";
		}
		return "pss/index";
	}
}
