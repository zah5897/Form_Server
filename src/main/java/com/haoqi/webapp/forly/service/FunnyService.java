package com.haoqi.webapp.forly.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoqi.webapp.forly.bean.Funny;
import com.haoqi.webapp.forly.dao.FunnyDao;

@Service
@Transactional(value = "txManager")
public class FunnyService {
	@Resource
	private FunnyDao funnyDao;

	public long insert(Funny funny) {
		return (Long) funnyDao.insert(funny);
	}

	public long spiderInsert(Funny funny) {
		return (Long) funnyDao.spiderInsert(funny);
	}
}
