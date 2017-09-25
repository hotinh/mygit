package cn.cc.myspring.proprety;

import java.io.IOException;
import java.util.*;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		
		Properties pro = new Properties();
		pro.load(TestProperties.class.getClassLoader().getResourceAsStream("application.properties"));
		
		Set keys = pro.keySet();
//		for (Object o : keys) {
//			System.out.println();
//		}
		
		keys.stream().forEach(e -> {
			System.out.println(e + "=" + pro.getProperty(e+""));
		});
		

	}

}
