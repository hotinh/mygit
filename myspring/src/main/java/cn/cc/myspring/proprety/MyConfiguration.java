package cn.cc.myspring.proprety;

import cn.cc.myspring.proprety.util.MyConfig;
import cn.cc.myspring.proprety.util.MyKey;
import cn.cc.myspring.proprety.util.PropertiesLoader;
import cn.cc.myspring.proprety.util.PropertiesWrapper;

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
