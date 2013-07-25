package com.dlhz.pss.sys.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlhz.core.util.DataUtil;
import com.dlhz.pss.sys.dao.MenuDao;
import com.dlhz.pss.sys.entity.Menu;

@Service
public class MenuService {

	@Autowired
	private MenuDao menuDao;

	public boolean addMenu(Menu Menu) {
		Map<String, Object> data = DataUtil.parseObjectToMap(Menu, Menu.class);
		return menuDao.addMenu(data);
	}

	public boolean deleteMenu(String idStr) {
		return menuDao.deleteMenu(idStr);
	}

}
