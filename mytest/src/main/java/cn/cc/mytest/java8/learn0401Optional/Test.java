package cn.cc.mytest.java8.learn0401Optional;

import java.util.*;

public class Test {

	public static void main(String[] args) throws Exception {
		
		Optional< String > fullName = Optional.ofNullable( null );
		System.out.println( "Full Name is set? " + fullName.isPresent() );        
		System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) ); 
		System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
		
		
		
	}
}
