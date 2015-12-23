package com.haoqi.webapp.forly.controller.api;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haoqi.webapp.forly.bean.Funny;
import com.haoqi.webapp.forly.controller.BaseController;
import com.haoqi.webapp.forly.service.FunnyService;
import com.haoqi.webapp.forly.util.HeaderUtil;

@RestController
@RequestMapping("/api/funny")
public class FunnyAPIController extends BaseController {

	@Resource
	private FunnyService funnyService;

	@RequestMapping("list")
	public Map<String, Object> list(long lastID, int pageSize) {
		funnyService.list(lastID, pageSize);
		return HeaderUtil.getResultOKMap();
	}

	@RequestMapping("add")
	public Map<String, Object> add(Funny funny) {
		long id = funnyService.insert(funny);
		funny.setId(id);
		Map<String, Object> result = HeaderUtil.getResultOKMap();
		result.put("funny", funny);
		return result;
	}

}
