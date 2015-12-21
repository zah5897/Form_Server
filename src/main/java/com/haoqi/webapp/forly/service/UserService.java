package com.haoqi.webapp.forly.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Service;

import com.haoqi.webapp.forly.bean.User;
import com.haoqi.webapp.forly.dao.UserDao;

@Service
@Transactional
public class UserService {
	@Resource
	private UserDao userDao;

	@Transactional
	public User getUser(long id) {
		return userDao.getUser(id);
	}

	@Transactional
	public User findUserByMobile(String mobile) {
		return userDao.findUserByMobile(mobile);
	}

	@Transactional
	public void delete(long id) {
		userDao.delete(id);
	}

	@Transactional(value = TxType.REQUIRED)
	public long insertUser(User user) {
		return (Long) userDao.insert(user);
	}

	@Transactional
	public List<?> getList() {
		return userDao.getList();
	}

	@Transactional(value = TxType.REQUIRED)
	public void update(User user) {
		userDao.update(user);
	}
}
