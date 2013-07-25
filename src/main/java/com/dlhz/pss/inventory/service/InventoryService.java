package com.dlhz.pss.inventory.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlhz.core.util.DataUtil;
import com.dlhz.pss.inventory.dao.InventoryDao;
import com.dlhz.pss.inventory.entity.Inventory;

@Service
public class InventoryService {

	@Autowired
	private InventoryDao inventoryDao;

	public boolean addInventory(Inventory inventory) {
		Map<String, Object> data = DataUtil.parseObjectToMap(inventory, Inventory.class);
		return inventoryDao.addInventory(data);
	}
}
