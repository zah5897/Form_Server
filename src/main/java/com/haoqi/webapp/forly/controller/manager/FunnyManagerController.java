package com.haoqi.webapp.forly.controller.manager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.haoqi.webapp.forly.bean.Funny;
import com.haoqi.webapp.forly.bean.User;
import com.haoqi.webapp.forly.controller.BaseController;
import com.haoqi.webapp.forly.service.FunnyService;
import com.haoqi.webapp.forly.util.TextUtils;

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
		String publisher_id = request.getParameter("user_id");
		if (TextUtils.isEmpty(publisher_id)) {
			long pId = Long.parseLong(publisher_id);
			funny.setPublisher(new User(pId));
			long id = funnyService.insert(funny);
		}
		return "funny/add";

	}
}
