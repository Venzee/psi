package com.vsoft.pss.sys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsoft.core.util.DataUtil;
import com.vsoft.pss.sys.dao.MenuDao;
import com.vsoft.pss.sys.entity.Menu;
import com.vsoft.pss.sys.entity.form.MenuForm;

@Service
public class MenuService {

	@Autowired
	private MenuDao menuDao;

	public boolean addMenu(Menu Menu) {
		Map<String, Object> data = DataUtil.parseObjectToMap(Menu, Menu.class);
		return menuDao.addMenu(data);
	}

	public List<MenuForm> queryAllMenu() {
		List<MenuForm> list = new ArrayList<MenuForm>();
		List<Map<String, Object>> datas = menuDao.queryAllMenu();
		Map<Integer, MenuForm> tempMap = new HashMap<Integer, MenuForm>();
		for (Map<String, Object> data : datas) {
			Menu menu = (Menu) DataUtil.parseMapToObject(data, Menu.class);
			if (menu.getParentId() == 0) {
				MenuForm menuForm = (MenuForm) tempMap.get(menu.getId());
				if (menuForm == null) {
					menuForm = new MenuForm();
				}
				menuForm.setMenu(menu);
				tempMap.put(menu.getId(), menuForm);
			}else{
				MenuForm menuForm = (MenuForm) tempMap.get(menu.getParentId());
				menuForm.getChildMenu().add(menu);
				tempMap.put(menu.getParentId(), menuForm);
			}
		}
		list.addAll(tempMap.values());
		return list;
	}

	public boolean deleteMenu(String idStr) {
		return menuDao.deleteMenu(idStr);
	}

}
