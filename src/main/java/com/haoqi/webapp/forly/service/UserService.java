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
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public User getUser(long id) {
		return userDao.getUser(id);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public User findUserByMobile(String mobile) {
		return userDao.findUserByMobile(mobile);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
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

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<?> getList() {
		return userDao.getList();
	}
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public int getUserCount(long id) {
		return userDao.getCountById(id);
	}

	public int update(User user) {
		return userDao.update(user.getNick_name(), user.getInfo(), user.getSex(), user.getAvatar(), user.getId());
	}
}
