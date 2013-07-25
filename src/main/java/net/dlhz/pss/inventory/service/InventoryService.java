package net.dlhz.pss.inventory.service;

import java.util.Map;

import net.dlhz.core.util.DataUtil;
import net.dlhz.pss.inventory.dao.InventoryDao;
import net.dlhz.pss.inventory.entity.Inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InventoryService {

	@Autowired
	private InventoryDao inventoryDao;

	public boolean addInventory(Inventory inventory) {
		Map<String, Object> data = DataUtil.parseObjectToMap(inventory, Inventory.class);
		return inventoryDao.addInventory(data);
	}
}
