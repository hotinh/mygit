package cn.cc.myspring.property;

import cn.cc.myspring.property.util.MyConfig;
import cn.cc.myspring.property.util.MyKey;
import cn.cc.myspring.property.util.PropertiesLoader;
import cn.cc.myspring.property.util.PropertiesWrapper;

@MyConfig("application.properties")
public class MyConfiguration {

	@MyKey("home.province")
	public static String name;
	
	static {
		PropertiesLoader.init(MyConfiguration.class);
	}
	
	public static void main(String[] args) {
		System.out.println(MyConfiguration.name);
		
		PropertiesWrapper wrapper = PropertiesLoader.load("application.properties");
		System.out.println(wrapper.get("home.province"));
	}
}
