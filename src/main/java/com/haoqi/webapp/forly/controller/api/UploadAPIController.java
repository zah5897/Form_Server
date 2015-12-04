package com.haoqi.webapp.forly.controller.api;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.haoqi.webapp.forly.bean.User;
import com.haoqi.webapp.forly.util.FileUtils;
import com.haoqi.webapp.forly.util.HeaderUtil;

/**
 * 文件上传控制器演示
 * 
 * http://git.oschina.net/sphsyv/sypro
 * 
 * @author 孙宇
 *
 */
@RestController
@RequestMapping("/api/file")
public class UploadAPIController {
	private static Logger log = Logger.getLogger(UploadAPIController.class);

	/**
	 * 上传文件演示，那个otherString可以替换成其他类、属性等等
	 * 
	 * @param multipartRequest
	 * @param session
	 * @param otherString
	 * @return
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public Map<String, Object> upload(DefaultMultipartHttpServletRequest multipartRequest, HttpSession session,
			User user) {
		log.info("注册手机号码:" + user.getMobile());
		if (multipartRequest != null) {
			Iterator<String> iterator = multipartRequest.getFileNames();
			while (iterator.hasNext()) {
				MultipartFile file = multipartRequest.getFile((String) iterator.next());
				if (!file.isEmpty()) {
					try {
						FileUtils.saveFile(file, session.getServletContext());
					} catch (Exception e) {
						e.printStackTrace();
						log.error(e.getMessage());
					}
				}
			}
		}
		return HeaderUtil.getResultOKMap();
	}

}
