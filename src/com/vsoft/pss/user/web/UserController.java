package com.vsoft.pss.user.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vsoft.core.base.entity.SessionUser;
import com.vsoft.core.util.SessionUtil;
import com.vsoft.pss.organization.entity.Company;
import com.vsoft.pss.organization.entity.Organization;
import com.vsoft.pss.sys.entity.form.MenuForm;
import com.vsoft.pss.sys.service.MenuService;
import com.vsoft.pss.user.entity.User;
import com.vsoft.pss.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MenuService menuService;

	@RequestMapping("/register/init")
	public String initRegister(HttpServletRequest request, ModelMap map, Organization organization, Company company, User user) {
		user = userService.register(organization, company, user);
		return login(request, map, user);
	}

	@RequestMapping("/register")
	public String register(HttpServletRequest request, User user, ModelMap map) {
		if ("".equals(user.getUsername()) || null == user.getUsername()) {
			map.put("tip", "用户名不能为空！");
			return "register";
		}
		if ("".equals(user.getPassword()) || null == user.getPassword()) {
			map.put("tip", "密码不能为空！");
			return "register";
		}
		user = userService.register(user);
		return login(request, map, user);
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, ModelMap map, User user) {
		boolean result = false;
		String sessionId = request.getSession().getId();
		SessionUser sessionUser = SessionUtil.getUserBySessionId(sessionId);
		if( sessionUser == null){
			sessionUser = new SessionUser();
			user = userService.login(user);
			if (user.getId() == 0) {
				map.put("tip", "用户名或密码错误！");
				return "login";
			}
			sessionUser.setUsername(user.getUsername());
			result = SessionUtil.putSession(sessionId, sessionUser);
			if (result) {
				return "redirect:/index";
			}
		}
		map.put("tip", "系统不允许两个用户同时在线！");
		return "login";
	}

	@RequestMapping("/index")
	public String index(HttpServletRequest request, ModelMap map) {
		String sessionId = request.getSession().getId();
		SessionUser sessionUser = SessionUtil.getUserBySessionId(sessionId);
		if (sessionUser == null) {
			return "login";
		}
		List<MenuForm> menuList = menuService.queryAllMenu();
		map.put("menuList", menuList);
		return "index";
	}
}
