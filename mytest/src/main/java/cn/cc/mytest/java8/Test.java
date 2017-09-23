package cn.cc.mytest.java8;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List receivers = new ArrayList();
		receivers.add("11");
		receivers.add("2");
		
		Object[] s = receivers.stream().toArray(String[]::new);
		
		System.out.println(Arrays.toString(s));
		
	}

}
