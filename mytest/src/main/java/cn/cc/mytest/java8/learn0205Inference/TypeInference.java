package cn.cc.mytest.java8.learn0205Inference;

import java.util.ArrayList;
import java.util.List;

public class TypeInference {
	
    public static void main(String[] args) {
    	
        final Value< String > value = new Value<>();
        
        value.getOrDefault( "22", Value.<String>defaultValue() );
        
        System.out.println(value);
        
        List<String> ls = new ArrayList<>();
    }
}
