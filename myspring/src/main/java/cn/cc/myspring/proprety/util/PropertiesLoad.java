package cn.cc.myspring.proprety.util;

import org.apache.commons.lang3.StringUtils;
import java.util.Properties;

public class PropertiesLoad {

	public static void init(Class clazz) {
		MyConfig config = (MyConfig)clazz.getAnnotation(MyConfig.class);
		
		if (config == null || StringUtils.isEmpty(config.value())) {
			throw new RuntimeException(String.format("Can not find %s's properties", clazz.getSimpleName()));
		}
		Properties prop = new Properties();
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
