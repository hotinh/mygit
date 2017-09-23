package cn.cc.mytest.java8.learn0301ParameterNames;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParameterNames {

	public static void main(String[] args) throws Exception {
		
        Method method = ParameterNames.class.getMethod( "main", String[].class );
        for( final Parameter parameter: method.getParameters() ) {
        	
        	System.out.println( "Parameter: " + parameter.isNamePresent() );
        	
            System.out.println( "Parameter: " + parameter.getName() );
        }
        
//        Method method2 = ParameterNames.class.getMethod( "test", Object[].class );
//        for( final Parameter parameter: method2.getParameters() ) {
//            System.out.println( "Parameter: " + parameter.getName() );
//        }
    }
	
	public void test(Object[] sdsd) {
		
	}
	
}
