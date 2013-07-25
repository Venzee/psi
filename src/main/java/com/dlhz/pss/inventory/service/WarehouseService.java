package com.dlhz.pss.inventory.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlhz.core.util.DataUtil;
import com.dlhz.pss.inventory.dao.WarehouseDao;
import com.dlhz.pss.inventory.entity.Warehouse;

@Service
public class WarehouseService {

	@Autowired
	private WarehouseDao warehouseDao;
	
	public boolean addWarehouse(Warehouse warehouse) {
		Map<String, Object> data = DataUtil.parseObjectToMap(warehouse, Warehouse.class);
		return warehouseDao.addWarehouse(data);
	}
}
