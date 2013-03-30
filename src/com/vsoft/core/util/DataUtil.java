package com.vsoft.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataUtil {

	private static final String[] UN_SUPPORT_TYPE = { "Integer", "String", "Boolean", "Long", "Character", "Byte", "Double", "Float", "Short" };

	public static boolean isNum(String str) {
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
	
	public static Object parseMapToObject(Map<String, Object> data, Class<?> pc) {
		Object obj = null;
		Class<?> c = null;
		try {
			c = Class.forName(pc.getName());
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
		for (Field field : fields) {
			int mod = field.getModifiers();
			if (!Modifier.isFinal(mod) && !Modifier.isStatic(mod)) {
				if (!field.getType().isPrimitive()) {
					boolean isBean = true;
					Class<?> type = field.getType();
					String typeSimpleName = type.getSimpleName();
					for (String str : UN_SUPPORT_TYPE) {
						if (str.equals(typeSimpleName)) {
							isBean = false;
							break;
						}
					}
					if (isBean) {
						Class<?> oc = null;
						try {
							oc = Class.forName(type.getName());
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						Field[] fs = oc.getDeclaredFields();
						Object o = null;
						try {
							o = oc.newInstance();
						} catch (InstantiationException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
						for (Field f : fs) {
							setter(f, o, data);
						}
						char[] fc = field.getName().toCharArray();
						StringBuffer lowerCaseFiledName = new StringBuffer();
						for (char ch : fc) {
							lowerCaseFiledName.append(Character.toLowerCase(ch));
						}
						data.put(lowerCaseFiledName.toString(), o);
					}
				}
				setter(field, obj, data);
			}
		}
		return obj;
	}

	public static Map<String, Object> parseObjectToMap(Object obj, Class<?> oc) {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		Class<?> c = null;
		try {
			c = Class.forName(oc.getName());
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
	
	protected static void setter(Field field, Object obj, Map<String, Object> data) {
		String fieldName = field.getName();
		Class<?> type = field.getType();
		char[] fc = fieldName.toCharArray();
		StringBuffer newFiledName = new StringBuffer();
		StringBuffer lowerCaseFiledName = new StringBuffer();
		for (char ch : fc) {
			lowerCaseFiledName.append(Character.toLowerCase(ch));
		}
		fc[0] = Character.toUpperCase(fc[0]);
		newFiledName.append(fc);
		setter(obj, newFiledName.toString(), data.get(lowerCaseFiledName.toString()), type);
	}

	protected static void setter(Object obj, String attr, Object value, Class<?> type) {
		try {
			String methodHead = "set";
			if (value != null) {
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
