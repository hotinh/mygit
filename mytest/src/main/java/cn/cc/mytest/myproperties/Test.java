package cn.cc.mytest.myproperties;

import java.util.*;
import java.io.*;

public class Test {

	public static void main(String[] args) throws IOException {
		
		InputStream in = 
				//new BufferedInputStream(new FileInputStream("alarm-config.properties"));
//				ClassLoader.getSystemResourceAsStream("alarm-config.properties");
				Test.class.getClassLoader().getResourceAsStream("alarm-config.properties");
		
		Properties prop = new Properties();
		prop.load(in);
		
		Set key = prop.keySet();
		for (Object o : key) {
			System.out.println(o + "=" + prop.getProperty(o+""));
		}
		
//		Properties pro = System.getProperties();
//		pro.list(System.out);

	}

}
