package com.haoqi.webapp.forly.controller.manager;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.haoqi.webapp.forly.bean.User;
import com.haoqi.webapp.forly.controller.BaseController;
import com.haoqi.webapp.forly.service.UserService;
import com.haoqi.webapp.forly.util.HeaderUtil;

@Controller
@RequestMapping("/manager/user")
public class UserManagerController extends BaseController {

	@Resource
	private UserService userService;

	@RequestMapping("info")
	public String info(long id, HttpServletRequest request) {
		User user = userService.getUser(id);
		request.setAttribute("user", user);
		return "user_info";
	}

	@RequestMapping("list")
	public Map<String, Object> list() {
		List<?> list = userService.getList();
		Map<String, Object> result = HeaderUtil.getResultOKMap();
		result.put("rows", list);
		return result;
	}

	@RequestMapping("add")
	public Map<String, Object> add(User user, HttpServletRequest request) {

		long id = userService.insertUser(user);
		Map<String, Object> result = null;
		result = HeaderUtil.getResultOKMap();
		user.setId(id);
		result.put("user", user);
		return result;
	}
}
