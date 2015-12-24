package com.haoqi.webapp.forly.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanWrapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.haoqi.webapp.forly.bean.Funny;
import com.haoqi.webapp.forly.bean.User;
import com.haoqi.webapp.forly.util.UserSupport;

@Repository("funnyDao")
public class FunnyDao extends BaseDao {
	public static final String TABLE = "t_funny";
	@Resource
	private JdbcTemplate jdbcTemplate;

	public long insert(Funny funny) {
		return (Long) saveObj(jdbcTemplate, TABLE, funny);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Funny> list(long lastID, int pageSize) {
		List<Funny> list = jdbcTemplate.query(
				"select funny.*,user.name,user.info,user.avatar "
				+ "from t_funny funny "
				+ "left join t_user user "
				+ "on funny.publisher=user.id  "
				+ "and funny.id<? order by funny.id desc "
				+ "limit ?",
				new Object[] { lastID, pageSize }, new BeanPropertyRowMapper(Funny.class) {
					@Override
					protected void initBeanWrapper(BeanWrapper bw) {
						super.initBeanWrapper(bw);
						bw.registerCustomEditor(User.class, new UserSupport());
					}
				});
		return list;
	}

	public long spiderInsert(Funny funny) {

		int count = jdbcTemplate.queryForObject("select count(*) from " + TABLE + " where content = ?",
				new String[] { funny.getContent() }, Integer.class);
		if (count > 0) {
			return -1l;
		} else {
			return insert(funny);
		}
	}

}
