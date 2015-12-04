package com.haoqi.webapp.forly.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.haoqi.webapp.forly.bean.User;

@Repository("userDao")
public class UserDao extends BaseDao {
	// @Resource
	// private SessionFactory sessionFactory;
	//
	// private Session getCurrentSession() {
	// return sessionFactory.getCurrentSession();
	// }

	public User getUser(long id) {
		return (User) getCurrentSession().get(User.class, id);
	}

	public List<?> getList() {
		return getCurrentSession().createQuery("from User").list();
	}

	public User findUserByMobile(String mobile) {
		String hql = "from User user where user.mobile=?";
		Query query = getCurrentSession().createQuery(hql);
		query.setString(0, mobile);
		List<?> result = query.list();
		if (result == null || result.size() == 0) {
			return null;
		} else {
			return (User) result.get(0);
		}
	}

	@Override
	public Serializable insert(Object obj) {
		User user = (User) obj;
		String hql = "from User user where user.mobile=?";
		Query query = getCurrentSession().createQuery(hql);
		query.setString(0, user.getMobile());
		List<?> result = query.list();
		if (result == null || result.size() == 0) {
			return getCurrentSession().save(user);
		} else {
			return new Long(-1L);
		}
	}

	public void delete(long id) {

		getCurrentSession().delete(new User(id));
	}
}
