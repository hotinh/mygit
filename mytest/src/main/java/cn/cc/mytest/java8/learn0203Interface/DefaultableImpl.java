package cn.cc.mytest.java8.learn0203Interface;

public class DefaultableImpl implements Defaulable {

	public static void main(String[] args) {
		System.out.println( new DefaultableImpl().notRequired() );
	}
}
