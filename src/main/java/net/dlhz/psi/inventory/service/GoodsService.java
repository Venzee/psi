package net.dlhz.psi.inventory.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.dlhz.core.base.entity.Page;
import net.dlhz.core.util.DataUtil;
import net.dlhz.psi.inventory.dao.GoodsDao;
import net.dlhz.psi.inventory.entity.Goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GoodsService {

	@Autowired
	private GoodsDao goodsDao;
	
	public boolean addGoods(Goods goods) {
		Map<String, Object> data = DataUtil.parseObjectToMap(goods, Goods.class);
		return goodsDao.addGoods(data);
	}
	
	public List<Goods> queryGoods(Page page) {
		List<Goods> list = new ArrayList<Goods>();
		List<Object> params = new ArrayList<Object>();
		params.add(page.getStartRecord());
		params.add(page.getPageRecord());
		List<Map<String, Object>> datas = goodsDao.queryGoods(params);
		for (Map<String, Object> data : datas) {
			Goods goods = (Goods) DataUtil.parseMapToObject(data, Goods.class);
			list.add(goods);
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
