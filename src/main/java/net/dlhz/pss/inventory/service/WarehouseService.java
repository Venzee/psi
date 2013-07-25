package net.dlhz.pss.inventory.service;

import java.util.Map;

import net.dlhz.core.util.DataUtil;
import net.dlhz.pss.inventory.dao.WarehouseDao;
import net.dlhz.pss.inventory.entity.Warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WarehouseService {

	@Autowired
	private WarehouseDao warehouseDao;
	
	public boolean addWarehouse(Warehouse warehouse) {
		Map<String, Object> data = DataUtil.parseObjectToMap(warehouse, Warehouse.class);
		return warehouseDao.addWarehouse(data);
	}
}
