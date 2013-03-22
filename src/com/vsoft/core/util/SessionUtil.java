package com.vsoft.core.util;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.vsoft.customer.user.entity.User;

public class SessionUtil {

	private static final Logger LOG = Logger.getLogger(SessionUtil.class);
	private static HashMap<String, User> sessionMap = new HashMap<String, User>(500, 0.95f);

	public static boolean putSession(String sessionId, User user) {
		User sessionUser = getUserBySessionId(sessionId);
		if (sessionUser == null) {
			synchronized (sessionMap) {
				sessionMap.put(sessionId, user);
				LOG.info("用户：" + user.getUsername() + "登陆系统；当前在线人数：" + sessionMap.size() + "；SessionId：" + sessionId);
				return true;
			}
		}
		return false;
	}

	public static boolean removeSession(String sessionId) {
		User user = getUserBySessionId(sessionId);
		synchronized (sessionMap) {
			sessionMap.remove(sessionId);
			LOG.info("用户：" + user.getUsername() + "退出系统；当前在线人数：" + sessionMap.size() + "；SessionId：" + sessionId);
		}
		return false;
	}

	public static boolean setTimeOut(String sessionId) {
		User user = getUserBySessionId(sessionId);
		if (user != null) {
			synchronized (sessionMap) {
				removeSession(sessionId);
				LOG.info("用户：" + user.getUsername() + "退出系统；当前在线人数：" + sessionMap.size() + "；SessionId：" + sessionId);
				return true;
			}
		}
		return false;
	}

	public static User getUserBySessionId(String sessionId) {
		User user = null;
		synchronized (sessionMap) {
			user = sessionMap.get(sessionId);
		}
		return user;
	}
}
