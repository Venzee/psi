package com.vsoft.pss.user.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vsoft.core.base.entity.SessionUser;
import com.vsoft.core.util.DataUtil;
import com.vsoft.core.util.SessionUtil;
import com.vsoft.pss.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(HttpServletRequest request, ModelMap map, @RequestParam String username,
			@RequestParam String password, @RequestParam String kaptcha) {
		boolean result = false;
		if(DataUtil.isEmptyStr(username)){
			map.put("tip", "用户名不能为空！");
			return "login";
		}
		if(DataUtil.isEmptyStr(password)){
			map.put("tip", "密码不能为空！");
			return "login";
		}
		if(DataUtil.isEmptyStr(kaptcha)){
			map.put("tip", "验证码不能为空！");
			return "login";
		}
		String sessionId = request.getSession().getId();
		SessionUser sessionUser = SessionUtil.getUserBySessionId(sessionId);
		if (sessionUser == null) {
			sessionUser = userService.login(username, password);
			if (sessionUser.getUserId() == 0) {
				map.put("tip", "用户名或密码错误！");
				return "login";
			}
			result = SessionUtil.putSession(sessionId, sessionUser);
			if (result) {
				String ip = getIpAddr(request);
				
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
		return "index";
	}

	private String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if(ip != null && ip.length() != 0 && !"unknow".equalsIgnoreCase((ip))){
			if(ip.indexOf(",") != -1){
				String ipArr[] = ip.split(",");
				for (int i = 0; i < ipArr.length; i++) {
					if(!ipArr[i].equalsIgnoreCase("unknow")){
						ip = ipArr[i];
					}
				}
			}
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
