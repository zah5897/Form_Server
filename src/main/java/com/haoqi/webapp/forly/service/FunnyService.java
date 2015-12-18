package com.haoqi.webapp.forly.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Service;

import com.haoqi.webapp.forly.bean.Funny;
import com.haoqi.webapp.forly.dao.FunnyDao;

@Service
@Transactional
public class FunnyService {
	@Resource
	private FunnyDao funnyDao;

	@Transactional(value = TxType.REQUIRED)
	public long insert(Funny funny) {
		return (Long) funnyDao.insert(funny);
	}
	// @Transactional(value = TxType.REQUIRED)
	// public long insertUser(User user) {
	// return (Long) userDao.insertUser(user);
	// }

	@Transactional
	public List<?> getList(int pn, int pageSize) {
		return funnyDao.getList(pn, pageSize);
	}

}
