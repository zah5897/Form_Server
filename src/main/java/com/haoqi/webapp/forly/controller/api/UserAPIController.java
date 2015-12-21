package com.haoqi.webapp.forly.controller.api;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.haoqi.webapp.forly.bean.User;
import com.haoqi.webapp.forly.controller.BaseController;
import com.haoqi.webapp.forly.dao.UserDao;
import com.haoqi.webapp.forly.exception.AppException;
import com.haoqi.webapp.forly.exception.ERROR;
import com.haoqi.webapp.forly.service.UserService;
import com.haoqi.webapp.forly.util.FileUtils;
import com.haoqi.webapp.forly.util.HeaderUtil;
import com.haoqi.webapp.forly.util.MD5Util;
import com.haoqi.webapp.forly.util.TextUtils;

@RestController
@RequestMapping("/api/user")
public class UserAPIController extends BaseController {
	private static Logger log = Logger.getLogger(UserAPIController.class);
	@Resource
	private UserService userService;

	@RequestMapping("info")
	public Map<String, Object> info(long id, HttpServletRequest request) {
		User user = userService.getUser(id);
		Map<String, Object> result = HeaderUtil.getResultOKMap();
		result.put("user", user);
		return result;
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

	@RequestMapping("regist")
	public Map<String, Object> regist(HttpServletRequest request) {

		String email = request.getParameter("mail");
		String password = request.getParameter("password");

		if (TextUtils.isEmpty(email)) {
			return HeaderUtil.getResultMap(ERROR.ERR_PARAM.setNewText("邮箱不能为空!"));
		}
		if (TextUtils.isEmpty(password)) {
			return HeaderUtil.getResultMap(ERROR.ERR_PARAM.setNewText("密码不能为空!"));
		}
		User user = new User();
		user.setName(email);
		user.setMail(email);
		user.setPassword(MD5Util.getMd5(password));
		long id = userService.insertUser(user);
		if (id == -1) {
			return HeaderUtil.getResultMap(ERROR.ERR_USER_EXIST);
		}
		Map<String, Object> result = HeaderUtil.getResultOKMap();
		user.setId(id);
		result.put("user", user);
		return result;
	}

	@RequestMapping("modify")
	public Map<String, Object> modify(DefaultMultipartHttpServletRequest multipartRequest) {

		String id = multipartRequest.getParameter("userId");
		long userId;
		try {
			userId = Long.parseLong(id);
		} catch (NumberFormatException e) {
			return HeaderUtil.getResultMap(ERROR.ERR_PARAM);
		}

		User user = userService.getUser(userId);
		if (user == null) {
			return HeaderUtil.getResultMap(ERROR.ERR_USER_NOT_EXIST);
		}

		String nickName = multipartRequest.getParameter("nickName");
		String info = multipartRequest.getParameter("info");
		String sex = multipartRequest.getParameter("sex");

		String iconPath = null;
		Iterator<String> iterator = multipartRequest.getFileNames();
		while (iterator.hasNext()) {
			MultipartFile file = multipartRequest.getFile((String) iterator.next());
			if (!file.isEmpty()) {
				try {
					iconPath = FileUtils.saveFile(file, multipartRequest.getServletContext()).getAbsolutePath();
				} catch (Exception e) {
					e.printStackTrace();
					log.error(e.getMessage());
				}
			}
		}

		user.setNickName(nickName);
		user.setInfo(info);
		user.setAvatar(iconPath);
		try {
			short s = Short.parseShort(sex);
			user.setSex(s);
		} catch (NumberFormatException e) {
			user.setSex((short) 0);
		}
		userService.update(user);
		Map<String, Object> result = HeaderUtil.getResultOKMap();
		result.put("user", user);
		return result;
	}

	// @RequestMapping("regist")
	// public Map<String, Object> regist(@RequestParam MultipartFile file,
	// HttpServletRequest request, User user) {
	//
	// // 手机号码不能为空
	// if (TextUtils.isEmpty(user.getMobile())) {
	// return HeaderUtil.getResultMap(ERROR.ERR_PARAM.setNewText("手机号码为空"));
	// }
	//
	// // 判断是否已经注册
	// User serverUser = userService.findUserByMobile(user.getMobile());
	// if (serverUser != null) {
	// return HeaderUtil.getResultMap(ERROR.ERR_USER_EXIST);
	// }
	// // 开始上传图片
	// String shortPath = null;
	// if (file != null && !file.isEmpty()) {
	// try {
	// shortPath = FileUtils.saveFileReturnShorePath(file,
	// request.getServletContext());
	// if (shortPath != null) {
	// } else {
	// return HeaderUtil.getResultMap(ERROR.ERR_FILE_UPLOAD);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// return HeaderUtil.getResultMap(ERROR.ERR_FILE_UPLOAD);
	// }
	// }
	// if (shortPath != null) {
	// user.setAvatar(shortPath);
	// }
	// long id = userService.insertUser(user);
	// user.setId(id);
	// Map<String, Object> result = HeaderUtil.getResultOKMap();
	// result.put("user", user);
	// return result;
	// }
}
