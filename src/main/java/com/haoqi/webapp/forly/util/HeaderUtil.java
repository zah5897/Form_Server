package com.haoqi.webapp.forly.util;

import java.util.HashMap;
import java.util.Map;

import com.haoqi.webapp.forly.exception.ERROR;

public class HeaderUtil {
	public static Map<String, Object> getResultMap(ERROR error) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("errorCode", error.getValue());
		result.put("errorMsg", error.getErrorMsg());
		return result;
	}

	public static Map<String, Object> getResultOKMap() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("errorCode", ERROR.ERR_NO_ERR.getValue());
		result.put("errorMsg", ERROR.ERR_NO_ERR.getErrorMsg());
		return result;
	}
}
