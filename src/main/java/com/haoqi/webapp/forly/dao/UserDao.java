package com.haoqi.webapp.forly.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.haoqi.webapp.forly.bean.User;

@SuppressWarnings("unchecked")
@Repository("userDao")
public class UserDao extends BaseDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	public User getUser(long id) {
		@SuppressWarnings("rawtypes")
		List<User> list = jdbcTemplate.query("select *from t_user user where user.id=?", new Object[] { id },
				new BeanPropertyRowMapper(User.class));
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	public int update(String nickName, String info, short sex, String avater, long id) {
		return jdbcTemplate.update("update t_user set nick_name=?,info=?,sex=?,avatar=? where id=?",
				new Object[] { nickName, info, sex, avater, id });
	}

	public List<?> getList() {
		@SuppressWarnings("rawtypes")
		List<User> list = jdbcTemplate.query("select *from t_user user", new BeanPropertyRowMapper(User.class));
		return list;
	}

	public User findUserByMobile(String mobile) {
		@SuppressWarnings("rawtypes")
		List<User> list = jdbcTemplate.query("select *from t_user user where user.mobile=?", new Object[] { mobile },
				new BeanPropertyRowMapper(User.class));
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	@SuppressWarnings("rawtypes")
	public User findUserByName(String name) {
		List<User> list = jdbcTemplate.query("select *from t_user user where user.name=?", new Object[] { name },
				new BeanPropertyRowMapper(User.class));
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	public int getCountByName(String name) {
		int count = jdbcTemplate.queryForObject("select count(*) from t_user user where user.name=?",
				new String[] { name }, Integer.class);
		return count;
	}

	public int getCountById(long id) {
		int count = jdbcTemplate.queryForObject("select count(*) from t_user user where user.name=?",
				new String[] { String.valueOf(id) }, Integer.class);
		return count;
	}

	public Serializable insert(User user) {
		return saveObj(jdbcTemplate, "t_user", user);
	}

	public void delete(long id) {
		jdbcTemplate.update("delete from t_user where id=?", new Object[] { id });
	}
}
