package cn.cc.mytest.java8.learn0203Method;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		
		String[] stringsArray = {"Hello","World"};

		//使用lambda表达式和类型对象的实例方法
		Arrays.sort(stringsArray,(s1,s2) -> s1.compareToIgnoreCase(s2));
		System.out.println(Arrays.asList(stringsArray));

		//使用方法引用
		//引用的是类型对象的实例方法
		Arrays.sort(stringsArray, String::compareToIgnoreCase);

	}

}
