package com.vsoft.pss.sys.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsoft.core.util.DataUtil;
import com.vsoft.pss.sys.dao.MenuDao;
import com.vsoft.pss.sys.entity.Menu;

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
