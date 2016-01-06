package com.haoqi.webapp.forly.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoqi.webapp.forly.bean.User;
import com.haoqi.webapp.forly.dao.UserDao;

@Service
@Transactional("transactionManager")
public class UserService {
	@Resource
	private UserDao userDao;

	public User getUser(long id) {
		return userDao.getUser(id);
	}

	public User findUserByMobile(String mobile) {
		return userDao.findUserByMobile(mobile);
	}

	@Transactional(readOnly = true)
	public User findUserByName(String name) {
		return userDao.findUserByName(name);
	}

	public void delete(long id) {
		userDao.delete(id);
	}

	public long insertUser(User user) {
		int count = userDao.getCountByName(user.getName());
		if (count > 0) {
			return -1;
		}
		long id = (Long) userDao.insert(user);
		return id;
	}

	public List<?> getList() {
		return userDao.getList();
	}

	public int getUserCount(long id) {
		return userDao.getCountById(id);
	}

	public int update(User user) {
		return userDao.update(user.getNick_name(), user.getInfo(), user.getSex(), user.getAvatar(), user.getId());
	}
}
