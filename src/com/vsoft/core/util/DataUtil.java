package com.vsoft.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.log4j.Logger;

public class DataUtil {

	private final static Logger LOG = Logger.getLogger(DataUtil.class);
	private static final String[] BASE_CLASS_TYPE = { "Integer", "String", "Boolean", "Long", "Character", "Byte", "Double", "Float", "Short" };

	/**
	 * 判断字符串是否是数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNum(String str) {
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmptyStr(String str) {
		if(null == str || "".equals(str) || str.trim().length() < 1){
			return true;
		}
		return false;
	}
	
	/**
	 * 中文字符串转拼音码
	 * 
	 * @param str
	 * @return
	 */
	public static String toPinYinStr(String str) {
		String pystr = "";
		String[] t = new String[str.length()];
		
		char [] hanzi=new char[str.length()];
        for(int i=0;i<str.length();i++){
            hanzi[i]=str.charAt(i);
        }
		
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
        
		try {
			for (int i = 0; i < str.length(); i++) {
				if ((str.charAt(i) >= 'a' && str.charAt(i) < 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
					pystr += str.charAt(i);
				} else {
		            t = PinyinHelper.toHanyuPinyinStringArray(hanzi[i], format);
		            pystr = pystr + t[0];
		        }
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}
		
		return pystr.trim().toString();
	}
	
	/**
	 * Map转换成对象
	 * 
	 * @param data
	 * @param pc
	 * @return
	 */
	public static Object parseMapToObject(Map<String, Object> data, Class<?> pc) {
		Object obj = null;
		Class<?> c = null;
		try {
			c = Class.forName(pc.getName());
		} catch (ClassNotFoundException e) {
			LOG.error("未找到类" + pc.getName(), e);
		}
		try {
			obj = c.newInstance();
		} catch (InstantiationException e) {
			LOG.error("实例化" + pc.getName() + "时异常", e);
		} catch (IllegalAccessException e) {
			LOG.error("非法访问异常", e);
		}
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			int mod = field.getModifiers();
			if (!Modifier.isFinal(mod) && !Modifier.isStatic(mod)) {
				if (!field.getType().isPrimitive()) {
					boolean isBean = true;
					Class<?> type = field.getType();
					String typeSimpleName = type.getSimpleName();
					for (String str : BASE_CLASS_TYPE) {
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
							LOG.error("未找到类" + type.getName(), e);
						}
						Field[] fs = oc.getDeclaredFields();
						Object o = null;
						try {
							o = oc.newInstance();
						} catch (InstantiationException e) {
							LOG.error("非法访问异常", e);
						} catch (IllegalAccessException e) {
							LOG.error("实例化" + oc.getName() + "时异常", e);
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

	/**
	 * 对象转换成Map
	 * 
	 * @param obj
	 * @param oc
	 * @return
	 */
	public static Map<String, Object> parseObjectToMap(Object obj, Class<?> oc) {
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		Class<?> c = null;
		try {
			c = Class.forName(oc.getName());
		} catch (ClassNotFoundException e) {
			LOG.error("未找到类" + oc.getName(), e);
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
				data.put(fields[i].getName(), getter(obj, fields[i].getType().getName(), newFiledName.toString()));
			}
		}
		return data;
	}

	protected static Object getter(Object obj, String type, String attr) {
		Class<?> c = obj.getClass();
		Method method = null;
		if (type.equals("boolean")) {
			try {
				method = c.getMethod("is" + attr);
			} catch (NoSuchMethodException | SecurityException e) {
				LOG.error("没有这个方法is" + attr + "或者因为安全问题无法访问", e);
			}
		} else {
			try {
				method = c.getMethod("get" + attr);
			} catch (NoSuchMethodException | SecurityException e) {
				LOG.error("没有这个方法get" + attr + "或者因为安全问题无法访问", e);
			}
		}
		try {
			obj = method.invoke(obj);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			LOG.error("调用方法" + method.getName() + "时发生异常", e);
		}
		return obj;
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
					if ("1".equals(value.toString()) || "true".equals(value)) {
						value = Boolean.TRUE;
					} else {
						value = Boolean.FALSE;
					}
				}
			}
			Method method = null;
			try {
				method = obj.getClass().getMethod("set" + attr, type);
			} catch (NoSuchMethodException | SecurityException e) {
				LOG.error("没有这个方法set" + attr + "或者因为安全问题无法访问", e);
			}
			try {
				method.invoke(obj, value);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				LOG.error("调用方法" + method.getName() + "时发生异常", e);
			}
		}
	}

}
