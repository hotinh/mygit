package cn.cc.mytest.java8.learn0203Method;

import java.util.function.*;
import java.util.*;

public class Car {
	
	public static void main(String[] args) {
		
		
    	final Car car = Car.create(Car :: new);
    	final List<Car> cars = Arrays.asList(car);
    	
    	cars.forEach(Car :: collide);
    	
    	cars.forEach(Car :: repair);
    	
    	final Car police = Car.create(Car :: new);
    	cars.forEach(police :: follow);
    	
    	Comparator<Integer> c2 = (x,y) -> Integer.compare(x, y);
    	Comparator<Integer> c1 = Integer :: compare;
    	
    	System.out.println(c2.compare(1, 2));
    	System.out.println(c1.compare(1, 2));
    	
    }

	public static Car create( final Supplier< Car > supplier ) {
        return supplier.get();
    }              
         
    public static void collide( final Car car ) {
        System.out.println( "Collided " + car.toString() );
    }
         
    public void follow( final Car another ) {
        System.out.println( "Following the " + another.toString() );
    }
         
    public void repair() {   
        System.out.println( "Repaired " + this.toString() );
    }

	@Override
	public String toString() {
		return "Car []";
	}
}
