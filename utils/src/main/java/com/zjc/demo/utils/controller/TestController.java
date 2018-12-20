package com.zjc.demo.utils.controller;

import com.zjc.demo.utils.mapper.InformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Sandu
 * @ClassName TestController
 * @date 2018/11/6
 */
@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private InformationMapper informationMapper;

	@GetMapping("/1")
	public Object hello(){
		List<Map> maps = informationMapper.listTable();
		for (Map table : maps) {
			Object name = table.get("TABLE_NAME");
			if(!name.equals("group_purchase_open")){
				continue;
			}
			Object comment = table.get("TABLE_COMMENT");
			List<Map> maps1 = informationMapper.listTableColumn(name.toString());
			return informationMapper.listTable();
		}
		return null;
	}
}
