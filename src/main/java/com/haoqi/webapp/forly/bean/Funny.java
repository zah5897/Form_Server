package com.haoqi.webapp.forly.bean;

import java.util.Date;

//@Table(name = "t_funny")
public class Funny{
	private long id;
	private long publisher_id; // 发布者

	private Date publishTime; // 发布时间

	private String title; // 标题
	private String content; // 内容
	private int praise_count; // 被赞次数
	private int store_count; // 被收藏次数
	private int category_type; // 类型

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(long publisher_id) {
		this.publisher_id = publisher_id;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPraise_count() {
		return praise_count;
	}

	public void setPraise_count(int praise_count) {
		this.praise_count = praise_count;
	}

	public int getStore_count() {
		return store_count;
	}

	public void setStore_count(int store_count) {
		this.store_count = store_count;
	}

	public int getCategory_type() {
		return category_type;
	}

	public void setCategory_type(int category_type) {
		this.category_type = category_type;
	}

}
