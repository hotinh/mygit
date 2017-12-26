package concurrent.javaConcurrency.chapter07.unit04.core;

import concurrent.javaConcurrency.chapter07.unit04.task.MyTask;
import concurrent.javaConcurrency.chapter07.unit04.task.MyThreadFactory;

public class Main {
	public static void main(String[] args) throws Exception {
		// 创建一个线程工厂
		MyThreadFactory myFactory = new MyThreadFactory("MyThreadFactory");
		
		// 创建一个任务
		MyTask task = new MyTask();
		
		Thread thread = myFactory.newThread(task);
		thread.start();
		
		thread.join();
		
		// 输出线程信息
        System.out.printf("Main: Thread information.\n");
        System.out.printf("%s\n", thread);
        System.out.printf("Main: End of the example.\n");
	}
}
