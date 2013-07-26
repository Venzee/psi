package net.dlhz.psi.inventory.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.dlhz.core.util.DataUtil;
import net.dlhz.psi.inventory.dao.BrandDao;
import net.dlhz.psi.inventory.dao.GoodsDao;
import net.dlhz.psi.inventory.dao.SortDao;
import net.dlhz.psi.inventory.entity.Sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SortService {

	@Autowired
	private SortDao sortDao;

	@Autowired
	private BrandDao brandDao;

	@Autowired
	private GoodsDao goodsDao;

	/**
	 * 新增类目
	 * 
	 * @param sort
	 * @return
	 */
	public boolean addSort(Sort sort) {
		Map<String, Object> data = DataUtil.parseObjectToMap(sort, Sort.class);
		if (sort.getId() == 0) {
			return sortDao.addSort(data);
		} else {
			return sortDao.updateSort(data);
		}
	}

	/**
	 * 新增类目并返回
	 * 
	 * @param sort
	 * @return
	 */
	public Sort addSortReturn(Sort sort) {
		Map<String, Object> data = DataUtil.parseObjectToMap(sort, Sort.class);
		String pinYinStr = DataUtil.toPinYinStr(sort.getName().substring(0, 1));
		data.put("code", pinYinStr.toUpperCase().substring(0, 1));
		data = sortDao.addSortAndReturn(data);
		sort = (Sort) DataUtil.parseMapToObject(data, Sort.class);
		return sort;
	}

	/**
	 * 获取类目
	 * 
	 * @param parentId
	 * @param goodsFlag 
	 * @param brandFlag 
	 * @return
	 */
	public List<Sort> querySort(String parentId, String brandFlag, String goodsFlag) {
		List<Sort> list = new ArrayList<Sort>();
		Map<String, Object> params = new LinkedHashMap<String, Object>();
		params.put("parentId", parentId);
		int count = sortDao.countSort(params);
		if (count > 0) {
			List<Map<String, Object>> datas = sortDao.querySort(parentId);
			for (Map<String, Object> data : datas) {
				Sort sort = (Sort) DataUtil.parseMapToObject(data, Sort.class);
				list.add(sort);
			}
		}
		return list;
	}

	/**
	 * 根据ID获取类目
	 * 
	 * @param id
	 * @return
	 */
	public Sort querySortById(String id) {
		Map<String, Object> data = sortDao.querySortById(id);
		Sort sort = (Sort) DataUtil.parseMapToObject(data, Sort.class);
		return sort;
	}
	
	/**
	 * 编辑类目信息
	 * 
	 * @param id
	 * @param name
	 * @param parentId
	 * @param primary
	 * @return
	 */
	public boolean editSort(String id, String name, String parentId, String main) {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		if(!DataUtil.isEmptyStr(id)){
			data.put("id", id);
		}
		if(!DataUtil.isEmptyStr(name)){
			data.put("name", name);
		}
		if(!DataUtil.isEmptyStr(parentId)){
			Map<String, Object> countData = new LinkedHashMap<String, Object>();
			data.put("parentId", parentId);
			countData.put("parentId", parentId);
			int count = sortDao.countSort(countData); // 统计是否有子类目
			if(count > 0){
				data.put("hasChild", true);
			}else{
				data.put("hasChild", false);
			}
		}
		if(!DataUtil.isEmptyStr(main)){
			if("true".equals(main)){
				data.put("main", true);
			}else{
				data.put("main", false);
			}
		}
		if(data.size() < 1){
			return false;
		}
		return sortDao.updateSort(data);
	}
	
	public boolean deleteSort(String idStr) {
		return sortDao.deleteSort(idStr);
	}
	
}
