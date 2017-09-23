package cn.cc.mytest.java8.learn0203Interface;

import java.util.function.Supplier;

public interface DefaulableFactory {
	
	public static void main( String[] args ) {
	    Defaulable defaulable = DefaulableFactory.create( DefaultableImpl::new );
	    System.out.println( defaulable.notRequired() );
	         
	    defaulable = DefaulableFactory.create( OverridableImpl::new );
	    System.out.println( defaulable.notRequired() );
	}

	static Defaulable create(Supplier< Defaulable > supplier ) {
        return supplier.get();
    }
	
}
