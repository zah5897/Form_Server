package com.haoqi.webapp.forly.bean.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.haoqi.webapp.forly.bean.Funny;
import com.haoqi.webapp.forly.util.PropertyMapperUtil;

public class FunnyMapper implements RowMapper<Funny> {

	public Funny mapRow(ResultSet rs, int rowNum) throws SQLException {
		// Funny user = new User();
		// user.setId(rs.getInt("id"));
		// user.setUsername(rs.getString("username"));
		// user.setPassword(rs.getString("password"));

		Funny f = null;
		try {
			f = (Funny) PropertyMapperUtil.prase(Funny.class, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

}
