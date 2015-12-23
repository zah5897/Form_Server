package com.haoqi.webapp.forly.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoqi.webapp.forly.bean.User;
import com.haoqi.webapp.forly.dao.UserDao;

@Service
@Transactional(value="txManager")
public class UserService {
	@Resource
	private UserDao userDao;

	public User getUser(long id) {
		return userDao.getUser(id);
	}

	public User findUserByMobile(String mobile) {
		return userDao.findUserByMobile(mobile);
	}

	public User findUserByName(String name) {
		return userDao.findUserByName(name);
	}

	public void delete(long id) {
		userDao.delete(id);
	}

 
	public long insertUser(User user) {
		return (Long) userDao.insert(user);
	}

	public List<?> getList() {
		return userDao.getList();
	}
	public void update(User user) {
		userDao.update(user);
	}
}
