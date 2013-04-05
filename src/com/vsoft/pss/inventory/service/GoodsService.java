package com.vsoft.pss.inventory.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vsoft.core.base.entity.Page;
import com.vsoft.core.util.DataUtil;
import com.vsoft.pss.inventory.dao.GoodsDao;
import com.vsoft.pss.inventory.entity.Goods;
import com.vsoft.pss.inventory.entity.form.GoodsForm;

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

	public boolean deleteGoods(String id) {
		return goodsDao.deleteGoods(id);
	}

	public void buildPage(Page page) {
		int count = goodsDao.countGoodsById();
		page.init(count);
	}
}
