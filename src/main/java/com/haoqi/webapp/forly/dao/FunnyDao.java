package com.haoqi.webapp.forly.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.haoqi.webapp.forly.bean.Funny;

@Repository("funnyDao")
public class FunnyDao extends BaseDao {
	public static final String TABLE = "t_funny";
	@Resource
	private JdbcTemplate jdbcTemplate;

	public long insert(Funny funny) {
		return (Long)saveObj(jdbcTemplate, TABLE, funny);
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
