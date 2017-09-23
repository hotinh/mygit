package cn.cc.mytest.javatuples;

import java.util.*;

import org.javatuples.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Double[] sf = {1.2,12.1};
		
		
		List list = new ArrayList();
		list.add(1);
		list.add("1");
		list.add(sf);
		
		
		Triplet<String, Integer, Double[]> triplet = Triplet.with("1", 2, sf);
		
		String myStr = triplet.getValue0();
		Integer myInteger = triplet.getValue1();
		Double[] myDoubleArray = triplet.getValue2();
		
		System.out.println(myStr);
		System.out.println(myInteger);
		System.out.println(Arrays.asList(myDoubleArray));
		
		Triplet<String, Integer, String> otherTriplet = triplet.setAt2("fdfdfdf");
		System.out.println(triplet.getValue(0));
		System.out.println(otherTriplet.getValue(0));
		
		Pair<String,Double[]> pair = triplet.removeFrom1();
		
		/*Quartet<String,Integer,Double[],Boolean> quartet = triplet.add(true); 
	
		Boolean myBoolean = quartet.getValue3();
		System.out.println(myBoolean);
		
		int i = quartet.indexOf(2);
		System.out.println(i);
		
		Object[] array = quartet.toArray();
		System.out.println(Arrays.asList(array));
		
		
		if (quartet.contains("1")) {
			System.out.println("---0---");
		}
		
		for (Object element : quartet) {
			System.out.println(element);
		}*/
		
		
		Triplet<String, Integer, Double> triplet_ = Triplet.with("1", 2, 21.1);
		Quintet<String,Integer,String, String, Double> quintet = triplet_.addAt2("Red Sea", "Caspian");
		
		
		byte b = 1;
		String[] sa = {"1"};
		Triplet<String,Integer,Double> triplet1 = Triplet.with("1", 2, 21.1);
		Triplet<Byte,String[],String> triplet2 = Triplet.with(b, sa, "dfd");
		Sextet<String, Integer, Byte, String[], String, Double> sextet = triplet1.addAt2(triplet2);
		
		
		String[] array = new String[] { "a", "b", "c", "d", "e" };
		Quintet<String,String,String,String,String> quartet = Quintet.fromArray(array); 
	}

}
