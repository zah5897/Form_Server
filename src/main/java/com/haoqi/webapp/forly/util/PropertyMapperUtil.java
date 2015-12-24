package com.haoqi.webapp.forly.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;

import com.haoqi.webapp.forly.annotation.ColumnType;
import com.haoqi.webapp.forly.annotation.Type;

public class PropertyMapperUtil {

	public static <T> Object prase(Class<T> clazz, ResultSet rs) throws Exception {
		// 获得对象属性
		Field field[] = clazz.getDeclaredFields();
		Object bean = clazz.newInstance();
		for (Field f : field) {
			f.setAccessible(true);
			ColumnType ignore = f.getAnnotation(ColumnType.class);
			if (ignore != null) {
				if (ignore.value() == Type.QUERY_OBJECT) {
					Object obj = prase(ignore.ClassType(), rs);
					Object v = invokeMethod(bean, f.getName(), new Object[] { obj });
				}
			} else {
				Object prop = rs.getObject(f.getName());
				Object v = invokeMethod(bean, f.getName(), new Object[] { prop });
			}
		}
		return bean;
	}

	private static Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {
		Class<? extends Object> ownerClass = owner.getClass();
		methodName = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
		Method method = null;
		try {
			method = ownerClass.getMethod("set" + methodName);
		} catch (SecurityException e) {
		} catch (NoSuchMethodException e) {
			return " can't find 'get" + methodName + "' method";
		}
		return method.invoke(owner, args);
	}
}
