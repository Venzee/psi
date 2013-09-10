package net.dlhz.psi.goods.service;

import java.util.Map;

import net.dlhz.core.util.DataUtil;
import net.dlhz.psi.goods.dao.WarehouseDao;
import net.dlhz.psi.goods.entity.Warehouse;

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
