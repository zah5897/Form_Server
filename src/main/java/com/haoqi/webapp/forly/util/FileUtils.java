package com.haoqi.webapp.forly.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	public static final String FILE_ROOT = "uploadfiles";

	public static String getServerFilePath(ServletContext servletContext) {
		return servletContext.getRealPath("/") + File.separator + FILE_ROOT + File.separator;
	}

	public static File saveFile(MultipartFile file, ServletContext servletContext)
			throws IllegalStateException, IOException {
		// System.out.println(file.getContentType());// 获取文件MIME类型
		// System.out.println(file.getName());// 获取表单中文件组件的名字
		// System.out.println(file.getOriginalFilename());// 获取上传文件的原名
		// System.out.println(file.getSize());// 获取文件的字节大小，单位byte
		// 文件保存路径
		String filePath = getServerFilePath(servletContext);
		String shortName = file.getOriginalFilename();
		if (!TextUtils.isEmpty(shortName)) {
			String fileShortName = null;
			if (shortName.contains(".")) {
				fileShortName = UUID.randomUUID() +"."+ shortName.split("\\.")[1];
			} else {
				fileShortName = UUID.randomUUID().toString();
			}
			File uploadFile = new File(filePath + fileShortName);
			uploadFile.mkdirs();
			file.transferTo(uploadFile);// 保存到一个目标文件中。
			return uploadFile;
		}
		return null;
	}

	public static String saveFileReturnShorePath(MultipartFile file, ServletContext servletContext)
			throws IllegalStateException, IOException {
		// System.out.println(file.getContentType());// 获取文件MIME类型
		// System.out.println(file.getName());// 获取表单中文件组件的名字
		// System.out.println(file.getOriginalFilename());// 获取上传文件的原名
		// System.out.println(file.getSize());// 获取文件的字节大小，单位byte
		// 文件保存路径
		String filePath = getServerFilePath(servletContext);
		String shortName = file.getOriginalFilename();
		if (!TextUtils.isEmpty(shortName)) {
			String fileShortName = null;
			if (shortName.contains(".")) {
				String splitName[] = shortName.split("\\.");
				fileShortName = UUID.randomUUID()+"." + splitName[1];
			} else {
				fileShortName = UUID.randomUUID().toString();
			}
			File uploadFile = new File(filePath + fileShortName);
			uploadFile.mkdirs();
			file.transferTo(uploadFile);// 保存到一个目标文件中。
			return File.separator + FILE_ROOT + File.separator + fileShortName;
		}
		return null;
	}

//	public static void main(String[] args) {
//		String name = "12.png";
//		String names[]=name.split("\\.");
//		System.out.println(names.length);
//	}

}
