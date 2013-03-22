package com.vsoft.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class DataUtil {

	public static Object parseMapToObject(Map<String, Object> data, String className) {
		Object obj = null;
		Class<?> c = null;
		try {
			c = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			obj = c.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		Field[] fields = c.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			String fieldName = fields[i].getName();
			int mod = fields[i].getModifiers();
			if (!Modifier.isFinal(mod) && !Modifier.isStatic(mod)) {
				char[] fc = fieldName.toCharArray();
				fc[0] = Character.toUpperCase(fc[0]);
				StringBuffer newFiledName = new StringBuffer();
				newFiledName.append(fc);
				setter(obj, newFiledName.toString(), data.get(fieldName), fields[i].getType());
			}
		}
		return obj;
	}

	public static Map<String, Object> parseObjectToMap(Object obj, String className) {
		Map<String, Object> data = new HashMap<String, Object>();
		Class<?> c = null;
		try {
			c = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Field[] fields = c.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			String fieldName = fields[i].getName();
			int mod = fields[i].getModifiers();
			if (!Modifier.isFinal(mod) && !Modifier.isStatic(mod)) {
				char[] fc = fieldName.toCharArray();
				fc[0] = Character.toUpperCase(fc[0]);
				StringBuffer newFiledName = new StringBuffer();
				newFiledName.append(fc);
				data.put(fields[i].getName(), getter(obj, newFiledName.toString()));
			}
		}
		return data;
	}

	protected static Object getter(Object obj, String attr) {
		try {
			Method method = obj.getClass().getMethod("get" + attr);
			return method.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	protected static void setter(Object obj, String attr, Object value, Class<?> type) {
		try {
			String methodHead = "set";
			if (type.isPrimitive()) {
				String name = type.getName();
				if (name.equals("int")) {
					value = Integer.parseInt(value.toString());
				} else if (name.equals("float")) {
					value = Float.parseFloat(value.toString());
				} else if (name.equals("double")) {
					value = Double.parseDouble(value.toString());
				} else if (name.equals("byte")) {
					value = Byte.parseByte(value.toString());
				} else if (name.equals("short")) {
					value = Short.parseShort(value.toString());
				} else if (name.equals("char")) {

				} else if (name.equals("long")) {
					value = Long.parseLong(value.toString());
				} else if (name.equals("boolean")) {
					value = Boolean.parseBoolean(value.toString());
					methodHead = "is";
				}
			}
			Method method = obj.getClass().getMethod(methodHead + attr, type);
			method.invoke(obj, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
