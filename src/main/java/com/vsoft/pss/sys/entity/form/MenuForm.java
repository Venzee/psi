package com.vsoft.pss.sys.entity.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.vsoft.pss.sys.entity.Menu;

public class MenuForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2739036244420984327L;
	private Menu menu;
	private List<Menu> childMenu = new ArrayList<Menu>();;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Menu> getChildMenu() {
		return childMenu;
	}

	public void setChildMenu(List<Menu> childMenu) {
		this.childMenu = childMenu;
	}

}
