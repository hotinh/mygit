package cn.cc.mytest.java8.learn0201Lambda;

public class TestRun implements Runnable {

	@Override
	public void run() {
		System.out.println("run...");
	}
	
	public static void main(String[] args) {
		new TestRun().run();
		
		
	}

}
