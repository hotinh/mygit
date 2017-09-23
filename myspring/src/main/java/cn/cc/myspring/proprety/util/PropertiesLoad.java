package cn.cc.myspring.proprety.util;

public class PropertiesLoad {

	public static void init(Class clazz) {
		MyConfig config = (MyConfig)clazz.getAnnotation(MyConfig.class);
	}
}
