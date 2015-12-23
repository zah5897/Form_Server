package com.haoqi.webapp.forly.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.haoqi.webapp.forly.bean.User;
import com.haoqi.webapp.forly.dao.UserDao;

@Service
@Transactional(value = "txManager")
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

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		userDao.delete(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public long insertUser(User user) {
		int count = userDao.getCountByName(user.getName());
		if (count > 0) {
			return -1;
		}
		return (Long) userDao.insert(user);
	}

	public List<?> getList() {
		return userDao.getList();
	}

	public int getUserCount(long id) {
		return userDao.getCountById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int update(User user) {
		return userDao.update(user.getNick_name(), user.getInfo(), user.getSex(), user.getAvatar(), user.getId());
	}
}
