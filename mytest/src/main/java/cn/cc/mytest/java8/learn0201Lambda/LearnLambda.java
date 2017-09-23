package cn.cc.mytest.java8.learn0201Lambda;

import java.util.*;
import java.util.concurrent.*;

import org.junit.Test;


public class LearnLambda {
	
	
	public static void main(String[] args) throws Exception {
		
		
		Arrays.asList(1,"2","dfd").forEach(e -> System.out.print(e + ","));
		System.out.println("");
		
		Arrays.asList(1,"2","dfd").forEach(e -> {
			System.out.print(e + ",");
		});
		System.out.println("");
		
		
		final String separator = ",";
		Arrays.asList("a", "b", "d").forEach((String e) -> System.out.print(e + separator));
		System.out.println();
		
		
		List<String> list = Arrays.asList("s", "q", "r");
		list.sort( (e1, e2) -> e1.compareTo(e2));
		System.out.println(list);
		
		
		GreetingService greetingService = fs -> System.out.println("Hello " + fs);
		greetingService.sayMessage("world");
		
		Runnable r1 = () -> {System.out.println("Hewe");};
		r1.run();
		
		// 1.8以前的内部匿名类
		Thread oldSchool = new Thread(new Runnable() {
	        @Override
	        public void run() {
	            System.out.println("This is from an anonymous class.");
	        }
		});
		oldSchool.start();
		
		//1.8 Lambda 表达式
		new Thread(() -> {
			System.out.println("This is from an anonymous method(lambda exp).");
		}).start();
//		oldSchoolEmbance.start();
		
		Callable<Runnable> c1 = () -> () -> { System.out.println("Nested lambda"); };
		c1.call().run();
		
		Callable<Integer> c2 = true ? (() -> 42) : (() -> 24);
		System.out.println(c2.call());
		
		
		
		
	}
	
	void t() {
		/*Property p1 = new Property("叫了个鸡", 1000, 500, 2);
	    Property p2 = new Property("张三丰饺子馆", 2300, 1500, 3);
	    Property p3 = new Property("永和大王", 580, 3000, 1);
	    Property p4 = new Property("肯德基", 6000, 200, 4);
	    List<Property> properties = Arrays.asList(p1, p2, p3, p4);
	    
	    properties.stream().filter(e -> e.sales < 1000).forEach(e -> {
	    	System.out.println(e);
	    });*/
	}

}
