package com.haoqi.webapp.forly.controller.manager;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.support.logging.Log;
import com.haoqi.webapp.forly.bean.User;
import com.haoqi.webapp.forly.controller.BaseController;
import com.haoqi.webapp.forly.service.UserService;
import com.haoqi.webapp.forly.util.HeaderUtil;
import com.haoqi.webapp.forly.util.TextUtils;

@Controller
@RequestMapping("/manager/user")
public class UserManagerController extends BaseController {

	@Resource
	private UserService userService;

	@RequestMapping("login")
	public String login(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if ("zah".equals(userName) && "123456".equals(password)) {
			return "user/manager";
		} else {
			return "redirect:/?param=-1";
		}
	}

	@RequestMapping("info")
	public String info(long id, HttpServletRequest request) {
		User user = userService.getUser(id);
		request.setAttribute("user", user);
		return "user_info";
	}

	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		List<?> list = userService.getList();
		request.setAttribute("list", list);
		return "user/list";
	}

	@RequestMapping("toAdd")
	public String toAdd() {
		return "user/add";
	}

	@RequestMapping("add")
	public ModelAndView add(User user, HttpServletRequest request) {
		long id = userService.insertUser(user);
		Map<String, Object> result = null;
		result = HeaderUtil.getResultOKMap();
		user.setId(id);
		result.put("user", user);
		return new ModelAndView("user/add", result);
	}

	@RequestMapping("del")
	public ModelAndView del(HttpServletRequest request) {
		String sid = request.getParameter("id");
		if (!TextUtils.isEmpty(sid)) {
			long id = Long.parseLong(sid);
			userService.delete(id);
		}
		return new ModelAndView("redirect:/manager/user/list ");
	}
}
