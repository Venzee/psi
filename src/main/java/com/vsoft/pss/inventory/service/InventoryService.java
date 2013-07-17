package com.vsoft.pss.inventory.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsoft.core.util.DataUtil;
import com.vsoft.pss.inventory.dao.InventoryDao;
import com.vsoft.pss.inventory.entity.Inventory;

@Service
public class InventoryService {

	@Autowired
	private InventoryDao inventoryDao;

	public boolean addInventory(Inventory inventory) {
		Map<String, Object> data = DataUtil.parseObjectToMap(inventory, Inventory.class);
		return inventoryDao.addInventory(data);
	}
}
