package net.dlhz.psi.inventory.web;

import java.util.List;

import net.dlhz.core.util.DataUtil;
import net.dlhz.psi.inventory.entity.Sort;
import net.dlhz.psi.inventory.service.SortService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/inventory/sort")
public class SortController {

	@Autowired
	private SortService sortService;

	@ResponseBody
	@RequestMapping(value= "/add", produces = "html/text;charset=utf-8")
	public String addSort(Sort sort) {
		return String.valueOf(sortService.addSort(sort));
	}
	
	/**
	 * 查看商品类目
	 * 
	 * @param map
	 * @param parentId
	 * @param brandFlag
	 * @return
	 */
	@RequestMapping("/list")
	public String querySort(ModelMap map, String parentId, String brandFlag, String goodsFlag) {
		Sort sort = null;
		if(DataUtil.isEmptyStr(parentId)){
			parentId = "0";
		}
		if(DataUtil.isEmptyStr(brandFlag)){
			brandFlag = "0";
		}
		if(DataUtil.isEmptyStr(goodsFlag)){
			goodsFlag = "0";
		}
		if(DataUtil.isNum(parentId) && Integer.parseInt(parentId) != 0){
			sort = sortService.querySortById(parentId);
		}
		if(null == sort){
			sort = new Sort();
			sort.setId(0);
			sort.setName("类目");
			if(Integer.parseInt(parentId) == 0){
				sort.setParentId(-1);
			}else{
				sort.setParentId(0);
			}
		}
		List<Sort> list = sortService.querySort(parentId, brandFlag, goodsFlag);
		map.put("brandFlag", brandFlag);
		map.put("goodsFlag", goodsFlag);
		map.put("sort", sort);
		map.put("sortList", list);
		return "inventory/sortlist";
	}
	
	@ResponseBody
	@RequestMapping("/edit")
	public String editSort(String id, String name, String parentId, String main) {
		return String.valueOf(sortService.editSort(id, name, parentId, main));
	}
	
	@ResponseBody
	@RequestMapping("/del")
	public String deleteSort(String idStr) {
		return String.valueOf(sortService.deleteSort(idStr));
	}
}
