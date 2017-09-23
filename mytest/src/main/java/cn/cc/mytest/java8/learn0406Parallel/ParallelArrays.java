package cn.cc.mytest.java8.learn0406Parallel;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

public class ParallelArrays {
	
    public static void main( String[] args ) {
    	
        long[] arrayOfLong = new long [  2000000 ];        
        
        long pre = System.currentTimeMillis();
        
//        Arrays.setAll(arrayOfLong, index -> ThreadLocalRandom.current().nextInt( 1000000 ));
        Arrays.parallelSetAll( arrayOfLong, index -> ThreadLocalRandom.current().nextInt( 1000000 ) );
        
        Arrays.stream( arrayOfLong ).limit( 10 ).forEach( 
            i -> System.out.print( i + " " ) );
        System.out.println();
        System.out.println(System.currentTimeMillis() - pre);
         
//        Arrays.sort(arrayOfLong);
        Arrays.parallelSort( arrayOfLong );     
        
        
        Arrays.stream( arrayOfLong ).limit( 10 ).forEach( 
            i -> System.out.print( i + " " ) );
        System.out.println();
        System.out.println(System.currentTimeMillis() - pre);
        
    }
    
}
