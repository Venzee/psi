package net.dlhz.psi.sys.service;

import java.util.Map;

import net.dlhz.core.util.DataUtil;
import net.dlhz.psi.sys.dao.MenuDao;
import net.dlhz.psi.sys.entity.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
