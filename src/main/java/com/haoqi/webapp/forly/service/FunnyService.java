package com.haoqi.webapp.forly.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<Funny> list(long lastID, int pageSize) {
		return funnyDao.list(lastID, pageSize);
	}

	public long spiderInsert(Funny funny) {
		return (Long) funnyDao.spiderInsert(funny);
	}
}
