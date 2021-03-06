package com.haoqi.webapp.forly.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.haoqi.webapp.forly.annotation.ColumnType;
import com.haoqi.webapp.forly.annotation.Type;

/**
 * @说明 对象操纵高级方法
 * @author cuisuqiang
 * @version 1.0
 * @since
 */
public class ObjectUtil {
	/**
	 * 返回一个对象的属性和属性值
	 */
	public static Map<String, String> getProperty(Object entityName) {
		Map<String, String> map = new HashMap<String, String>();
		Class<? extends Object> c = entityName.getClass();
		// 获得对象属性
		Field field[] = c.getDeclaredFields();
		for (Field f : field) {
			f.setAccessible(true);
			ColumnType ignore = f.getAnnotation(ColumnType.class);
			if (ignore != null) {
				if (ignore.value() == Type.IGNORE_PERSISTENCE) {
					continue;
				}
			}
			try {
				Object v = invokeMethod(entityName, f.getName(), null);
				if (v != null) {
					map.put(f.getName(), v.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return map;
	}

	/**
	 * 获得对象属性的值
	 */
	private static Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {
		Class<? extends Object> ownerClass = owner.getClass();
		methodName = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
		Method method = null;
		try {
			method = ownerClass.getMethod("get" + methodName);
		} catch (SecurityException e) {
		} catch (NoSuchMethodException e) {
			return " can't find 'get" + methodName + "' method";
		}
		return method.invoke(owner);
	}
}
