package cn.cc.mytest.java8.learn0204Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

public class RepeatingAnnotations {
	
	public static void main(String[] args) {
        for( Filter filter: Filterable.class.getAnnotationsByType( Filter.class ) ) {
            System.out.println( filter.value() );
        }
        
        Arrays.asList(Filterable.class.getAnnotations()).forEach(e -> {
//        	if (e instanceof Filter) {
        		System.out.println(e);
//        	}
        });
        
        Filterable.class.getDeclaredAnnotations();
        
        Arrays.asList(Filterable.class.getDeclaredAnnotations()).forEach(e -> {
//        	if (e instanceof Filter) {
        		System.out.println(e);
//        	}
        });
    }

	@Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    public @interface Filters {
        Filter[] value();
    }
     
    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    @Repeatable( Filters.class )
    public @interface Filter {
        String value();
    };
     
    @Filter( "filter1" )
    @Filter( "filter2" )
    public interface Filterable {        
    }
}
