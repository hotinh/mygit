package javaConcurrentcy.chapter01.unit09.core;

import javaConcurrentcy.chapter01.unit09.handler.ExceptionHandler;
import javaConcurrentcy.chapter01.unit09.task.Task;

public class Main {

	public static void main(String[] args) {
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
		
		try {
			thread.join();
		} catch (InterruptedException e) {
		}
		System.out.printf("Thread has finished\n");
	}

}
