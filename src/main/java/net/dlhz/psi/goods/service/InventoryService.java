package net.dlhz.psi.goods.service;

import java.util.Map;

import net.dlhz.core.util.DataUtil;
import net.dlhz.psi.goods.dao.InventoryDao;
import net.dlhz.psi.goods.entity.Inventory;

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
