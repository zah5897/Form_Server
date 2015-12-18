package com.haoqi.webapp.forly.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("funnyDao")
public class FunnyDao extends BaseDao {
	// public Serializable insertUser(User user) {
	// // Serializable ret;
	// // try {
	// // ret = getCurrentSession().save(user);
	// //
	// // } catch (ConstraintViolationException e) {
	// // ret = new Long(-1L);
	// // throw new AppException(ERROR.ERR_USER_EXIST, e);
	// // }
	// // return ret;
	// String hql = "from User user where user.mobile=?";
	// Query query = getCurrentSession().createQuery(hql);
	// query.setString(0, user.getMobile());
	// List<?> result = query.list();
	// if (result == null || result.size() == 0) {
	// return getCurrentSession().save(user);
	// } else {
	// return new Long(-1L);
	// }
	// }

	public List<?> getList(int pn, int pageSize) {
		return getCurrentSession().createQuery("from User").setFirstResult((pn - 1) * pageSize).setMaxResults(pageSize)
				.list();
	}

	@Override
	public Serializable insert(Object obj) {
		return getCurrentSession().save(obj);
	}

	// public List<?> getList() {
	// return getCurrentSession().createQuery("from User").list();
	// }

	// public User findUserByMobile(String mobile) {
	// String hql = "from User user where user.mobile=?";
	// Query query = getCurrentSession().createQuery(hql);
	// query.setString(0, mobile);
	// List<?> result = query.list();
	// if (result == null || result.size() == 0) {
	// return null;
	// } else {
	// return (User) result.get(0);
	// }
	// }
}
