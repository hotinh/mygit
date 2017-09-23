package cn.cc.mytest.java8.learn0402Stream;

import java.util.*;

public class LearnStream {

	public static void main(String[] args) {
		
		
		List<List<String>> lists = new ArrayList<List<String>>();
        lists.add(Arrays.asList("apple", "click"));
        lists.add(Arrays.asList("boss", "dig", "qq", "vivo"));
        lists.add(Arrays.asList("c#", "biezhi"));
        
        long l = lists.stream()
                .flatMap(Collection::stream)
                .filter(str -> str.length() > 2)
                .count();
        System.out.println(l);
        
		
		Property p1 = new Property("叫了个鸡", 1000, 500, 2);
	    Property p2 = new Property("张三丰饺子馆", 2300, 1500, 3);
	    Property p3 = new Property("永和大王", 580, 3000, 1);
	    Property p4 = new Property("肯德基", 6000, 200, 4);
	    List<Property> properties = Arrays.asList(p1, p2, p3, p4);
	    
	    System.out.println("---原始顺序---");
	    properties.forEach(e -> System.out.println(e));
	    
//	    Collections.sort(properties, (x, y) -> x.distance.compareTo(y.distance));
//	    Collections.sort(properties, (x, y) -> x.compareTo(y));
	    Collections.sort(properties, Property :: compareTo);
	    String name = properties.get(0).name;
	    System.out.println("距离我最近的店铺是:" + name);
	    
	    
	    properties.forEach(e -> System.out.println(e));
	    
	    
	    long count2 = properties.stream()
                .filter(p -> p.sales > 1000)
                .count();
	    System.out.println(count2);
	    
	    
	    Property property = properties.stream()
	            .max(Comparator.comparingInt(p -> p.priceLevel))
	            .get();
	    System.out.println(property);
	    
	    
//	    System.out.println("---");
//	    properties.forEach(Property :: sss);

	    
	}

}
