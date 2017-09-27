package cn.cc.myspring.property.util;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class PropertiesLoader {
	
	private static Map<String, PropertiesWrapper> propertiesWrapperMap = new HashMap();

	/**
	 * 初始化类的字段，需要用 @MyConfig 和 @MyKey 来标记类和类中的属性。
	 * 属性必须用static来修饰
	 */
	public static void init(Class clazz) {
		
		// 读取配置文件
		MyConfig config = (MyConfig)clazz.getAnnotation(MyConfig.class);
		if (config == null || StringUtils.isEmpty(config.value())) {
			throw new RuntimeException(String.format("Can not find %s's properties", clazz.getSimpleName()));
		}
		Properties prop = new Properties();
		try {
			prop.load(PropertiesLoader.class.getClassLoader().getResourceAsStream(config.value()));
		} catch (IOException e) {
			throw new RuntimeException(String.format("Can not load %s's properties", clazz.getSimpleName()));
		}
		
		// 获取需要注入配置的字段
		Map<Field, MyKey> keyFields = new HashMap<Field, MyKey>();
		Field[] fields = clazz.getFields();
		for (Field field : fields) {
			MyKey key = field.getAnnotation(MyKey.class);
			if (key != null) {
				keyFields.put(field, field.getAnnotation(MyKey.class));
			}
		}
		
		
		// 注入配置
		for (Field field: keyFields.keySet()) {
			MyKey key = keyFields.get(field);
			Class type = field.getType();
			String value = prop.getProperty(key.value());
			try {
				if (type == String.class) {
					field.set(type, value);
				} else if (type == Integer.class) {
					field.set(null, Integer.valueOf(value));
				} else if (type == Boolean.class) {
					field.set(null, "TRUE".equals(value) || "true".equals(value) || "1".equals(value));
				} else if (type == Double.class) {
					field.set(null, Double.valueOf(value));
				} else if (type == Float.class) {
					field.set(null, Float.valueOf(value));
				} else if (type == Long.class) {
					field.set(null, Long.valueOf(value));
				} else {
					throw new RuntimeException(String.format("Un-support load %s properties", type.getSimpleName()));
				}
			} catch (IllegalAccessException e) {
				throw new RuntimeException("Can not access field, " + e.getMessage());
			}
		}
	}
	
	public static synchronized PropertiesWrapper load(String filename) {
		if (StringUtils.isEmpty(filename)) {
			throw new java.lang.IllegalArgumentException("Properties filename can't not be null");
		}
		
		if (propertiesWrapperMap.containsKey(filename)) {
			return propertiesWrapperMap.get(filename);
		}
		
		Properties prop = new Properties();
		try {
			prop.load(PropertiesLoader.class.getClassLoader().getResourceAsStream(filename));
		} catch (IOException e) {
			throw new RuntimeException("Can not load properties from $s");
		}
		
		PropertiesWrapper wrapper = new PropertiesWrapper(prop);
		propertiesWrapperMap.put(filename, wrapper);
		return wrapper;
	}
}
