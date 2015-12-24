package com.haoqi.webapp.forly.bean.property;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime extends Date {
	/**
	 * 
	 */

	public DateTime(long time) {
		super(time);
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(this);
	}
}
