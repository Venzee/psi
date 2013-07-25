package com.dlhz.pss.inventory.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlhz.core.base.entity.Page;
import com.dlhz.core.util.DataUtil;
import com.dlhz.pss.inventory.dao.GoodsDao;
import com.dlhz.pss.inventory.entity.Goods;
import com.dlhz.pss.inventory.entity.form.GoodsForm;

@Service
public class GoodsService {

	@Autowired
	private GoodsDao goodsDao;
	
	public boolean addGoods(Goods goods) {
		Map<String, Object> data = DataUtil.parseObjectToMap(goods, Goods.class);
		return goodsDao.addGoods(data);
	}
	
	
	public List<GoodsForm> queryAllGoods(Page page) {
		List<GoodsForm> list = new ArrayList<GoodsForm>();
		List<Object> params = new ArrayList<Object>();
		params.add(page.getStartRecord());
		params.add(page.getPageRecord());
		List<Map<String, Object>> datas = goodsDao.queryAllGoods(params);
		for (Map<String, Object> data : datas) {
			GoodsForm goodsForm = (GoodsForm) DataUtil.parseMapToObject(data, GoodsForm.class);
			list.add(goodsForm);
		}
		return list;
	}
	
	public Goods queryOneGoods(Object id) {
		Map<String, Object> data = goodsDao.queryOneGoods(Arrays.asList(id));
		Goods goods = (Goods) DataUtil.parseMapToObject(data, Goods.class);
		return goods;
	}

	public boolean deleteGoods(String idStr) {
		return goodsDao.deleteGoods(idStr);
	}

	public void buildPage(Page page) {
		Map<String, Object> params = new LinkedHashMap<String, Object>();
		int count = goodsDao.countGoods(params);
		page.init(count);
	}
}
