package net.dlhz.psi.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.dlhz.core.base.entity.SessionUser;
import net.dlhz.core.util.DataUtil;
import net.dlhz.core.util.SessionUtil;
import net.dlhz.psi.user.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public int login(String sessionId, String username, String password) {
		int count = userDao.countByUsername(username);
		if (count > 0) {
			List<Object> params = new ArrayList<Object>();
			params.add(username);
			params.add(password);
			Map<String, Object> data = userDao.queryUserForLogin(params);
			if (null != data && !data.isEmpty()) {
				SessionUser sessionUser = (SessionUser) DataUtil.parseMapToObject(data, SessionUser.class);
				boolean login = SessionUtil.putSession(sessionId, sessionUser);
				if (login) {
					return 0;
				}
				return 9;
			}
			return 6;
		}
		return 5;
	}
}
