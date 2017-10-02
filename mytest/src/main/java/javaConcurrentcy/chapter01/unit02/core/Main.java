package javaConcurrentcy.chapter01.unit02.core;

import javaConcurrentcy.chapter01.unit02.task.Calculator;

public class Main {

	public static void main(String[] args) {
		// 创建一个知心10次循环。在每次循环中创建一个Calculator对象，
		// 一个 Thread 对象，这个Thread 对象使用刚创建的 Calculator 对象作为构造器的参数，
		// 然后调用刚创建的Thread对象的start() 方法
		 for (int i = 0; i<=10; i++) {
			 Calculator calculator = new Calculator(i);
			 Thread thread = new Thread(calculator);
			 thread.start();
		 }
	}

}
