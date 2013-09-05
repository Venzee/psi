package net.dlhz.core.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.dlhz.core.base.entity.SessionUser;

import org.apache.log4j.Logger;

public class SessionUtil {

	private static final Logger LOG = Logger.getLogger(SessionUtil.class);
	private static Map<String, SessionUser> sessionMap = new ConcurrentHashMap<String, SessionUser>(500, 0.95f);

	public static boolean putSession(String sessionId, SessionUser user) {
		SessionUser sessionUser = getUserBySessionId(sessionId);
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
		SessionUser user = getUserBySessionId(sessionId);
		synchronized (sessionMap) {
			sessionMap.remove(sessionId);
			LOG.info("用户：" + user.getUsername() + "退出系统；当前在线人数：" + sessionMap.size() + "；SessionId：" + sessionId);
		}
		return false;
	}

	public static boolean setTimeOut(String sessionId) {
		SessionUser user = getUserBySessionId(sessionId);
		if (user != null) {
			synchronized (sessionMap) {
				removeSession(sessionId);
				LOG.info("用户：" + user.getUsername() + "退出系统；当前在线人数：" + sessionMap.size() + "；SessionId：" + sessionId);
				return true;
			}
		}
		return false;
	}

	public static SessionUser getUserBySessionId(String sessionId) {
		SessionUser user = null;
		synchronized (sessionMap) {
			user = sessionMap.get(sessionId);
		}
		return user;
	}
}
