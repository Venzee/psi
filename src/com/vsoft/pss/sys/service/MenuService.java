package com.vsoft.pss.sys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vsoft.core.base.entity.Page;
import com.vsoft.core.util.DataUtil;
import com.vsoft.pss.sys.dao.MenuDao;
import com.vsoft.pss.sys.entity.Menu;
import com.vsoft.pss.sys.entity.form.MenuFrom;

@Service
public class MenuService {

	@Autowired
	private MenuDao menuDao;

	public boolean addMenu(Menu Menu) {
		Map<String, Object> data = DataUtil.parseObjectToMap(Menu, Menu.class);
		return menuDao.addMenu(data);
	}

	public List<MenuFrom> queryAllMenu(Page page) {
		List<MenuFrom> list = new ArrayList<MenuFrom>();
		List<Object> params = new ArrayList<Object>();
		params.add(page.getStartRecord());
		params.add(page.getPageRecord());
		List<Map<String, Object>> datas = menuDao.queryAllMenu(params);
		for (Map<String, Object> data : datas) {
			MenuFrom MenuFrom = (MenuFrom) DataUtil.parseMapToObject(data, MenuFrom.class);
			list.add(MenuFrom);
		}
		return list;
	}
	
	public List<Menu> queryMenuByIndustry(Menu form) {
		List<Menu> list = new ArrayList<Menu>();
		List<Object> params = new ArrayList<Object>();
		List<Map<String, Object>> datas = menuDao.queryAllMenu(params);
		for (Map<String, Object> data : datas) {
			Menu Menu = (Menu) DataUtil.parseMapToObject(data, Menu.class);
			list.add(Menu);
		}
		return list;
	}
	
	public void buildPage(Page page) {
		int count = menuDao.countMenuById();
		page.init(count);
	}

	public boolean deleteMenu(String idStr) {
		return menuDao.deleteMenu(idStr);
	}
	
}
