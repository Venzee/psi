package net.dlhz.psi.user.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.dlhz.core.base.entity.SessionUser;
import net.dlhz.core.util.DataUtil;
import net.dlhz.core.util.SessionUtil;
import net.dlhz.psi.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/login", produces = "text/html;charset=UTF-8")
	public String login(HttpServletRequest request, @RequestParam String username, @RequestParam String password,
			@RequestParam String kaptcha) {
		/**
		 * result code: 
		 * 		1:用户名不能为空 
		 * 		2:密码不能为空 
		 * 		3:验证码不能为空 
		 * 		4:验证码错误 
		 * 		5:用户名不存在 
		 * 		6:密码错误 
		 * 		7:
		 * 		8: 
		 * 		9:不允许同时登陆两个账号 0:登录成功
		 */
		int result = 0;
		if (DataUtil.isEmptyStr(username)) {
			result = 1;
		}
		if (DataUtil.isEmptyStr(password)) {
			result = 2;
		}
		if (DataUtil.isEmptyStr(kaptcha)) {
			result = 3;
		}
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		SessionUser sessionUser = SessionUtil.getUserBySessionId(sessionId);
		if (sessionUser == null) {
			result = userService.login(sessionId, username, password);
			sessionUser = SessionUtil.getUserBySessionId(sessionId);
			session.setAttribute("sessionUser", sessionUser);
		}else{
			result = 9;
		}
		return JSON.toJSONString(result);
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
		if (ip != null && ip.length() != 0 && !"unknow".equalsIgnoreCase((ip))) {
			if (ip.indexOf(",") != -1) {
				String ipArr[] = ip.split(",");
				for (int i = 0; i < ipArr.length; i++) {
					if (!ipArr[i].equalsIgnoreCase("unknow")) {
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
