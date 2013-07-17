package com.vsoft.pss.inventory.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsoft.core.util.DataUtil;
import com.vsoft.pss.inventory.dao.WarehouseDao;
import com.vsoft.pss.inventory.entity.Warehouse;

@Service
public class WarehouseService {

	@Autowired
	private WarehouseDao warehouseDao;
	
	public boolean addWarehouse(Warehouse warehouse) {
		Map<String, Object> data = DataUtil.parseObjectToMap(warehouse, Warehouse.class);
		return warehouseDao.addWarehouse(data);
	}
}
