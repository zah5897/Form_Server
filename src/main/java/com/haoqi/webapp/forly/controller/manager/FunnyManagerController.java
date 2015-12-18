package com.haoqi.webapp.forly.controller.manager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.haoqi.webapp.forly.bean.Funny;
import com.haoqi.webapp.forly.bean.User;
import com.haoqi.webapp.forly.controller.BaseController;
import com.haoqi.webapp.forly.service.FunnyService;

@Controller
@RequestMapping("/manager/funny")
public class FunnyManagerController extends BaseController {

	@Resource
	private FunnyService funnyService;

	@RequestMapping("toAdd")
	public String toAdd() {
		return "funny/add";
	}

	@RequestMapping("add")
	public String add(Funny funny, HttpServletRequest request) {
		funny.setPublisher(new User(1));
		long id = funnyService.insert(funny);
		return "funny/add";
	}
}
