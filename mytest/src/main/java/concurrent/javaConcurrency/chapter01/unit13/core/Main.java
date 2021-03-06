package concurrent.javaConcurrency.chapter01.unit13.core;

import concurrent.javaConcurrency.chapter01.unit13.factory.MyThreadFactory;
import concurrent.javaConcurrency.chapter01.unit13.task.Task;

public class Main {
	public static void main(String[] args) {
		// 创建一个线程工厂
		MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
		// 创建一个任务
		Task task = new Task();
		Thread thread;
		// 创建并且启动10个线程对象
		System.out.printf("Starting the Threads\n");
		for (int i=0; i<10; i++) {
			thread = factory.newThread(task);
			thread.start();
		}
		// 打印线程工厂的统计信息
		System.out.printf("Factory stats:\n");
		System.out.printf("%s\n", factory.getStatus());
	}
}
