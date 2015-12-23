package com.haoqi.webapp.forly.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;

import com.haoqi.webapp.forly.bean.Category;
import com.haoqi.webapp.forly.bean.DateTime;
import com.haoqi.webapp.forly.bean.Funny;
import com.haoqi.webapp.forly.bean.User;
import com.haoqi.webapp.forly.service.FunnyService;

public class SpiderWork {

	@Resource
	private FunnyService funnyService;

	private long maxTime;

	public void work() {
		System.out.println("----------------------");

		handler();
	}

	private void handler() {
		String url = "http://neihanshequ.com/joke/?is_json=1&app_name=neihanshequ_web&max_time=";
		if (maxTime == 0) {
			maxTime = System.currentTimeMillis() / 1000;
		}
		url += maxTime;
		String jsonStr = requestUrl(url);
		if (jsonStr != null) {
			JSONObject root = new JSONObject(jsonStr);
			JSONObject data = root.optJSONObject("data");
			long max_time = data.optLong("max_time");
			maxTime = max_time;
			boolean hasMore = data.optBoolean("has_more");
			if (!hasMore) {
				maxTime = 0;
			}
			JSONArray dataArray = data.optJSONArray("data");
			if (dataArray != null) {
				int len = dataArray.length();
				for (int i = 0; i < len; i++) {
					JSONObject item = dataArray.optJSONObject(i).optJSONObject("group");

					long create_time = item.optLong("create_time"); // create_time:
																	// 1444110972,
					String content = item.optString("content");

					Funny f = new Funny();
					f.setContent(content);
					f.setTitle(content);
					f.setPublisher(new User(2l));
					f.setPublish_time(new DateTime(create_time * 1000));
					f.setCategory_type(Category.FUNNY.getValue());
					long id = funnyService.insert(f);
					if (id > 0) {
						System.out.println("插入成功");
					} else {
						System.out.println("已经存在了");
					}
				}
			}

		}
	}

	private String requestUrl(String urlStr) {

		URL url = null;
		try {
			url = new URL(urlStr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		BufferedReader r = null;
		try {
			URLConnection con = url.openConnection();
			r = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		StringBuilder sb = new StringBuilder();
		String str = "";
		do {
			try {
				str = r.readLine();
				sb.append(str);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} while (str != null);
		return sb.toString();
	}
}
