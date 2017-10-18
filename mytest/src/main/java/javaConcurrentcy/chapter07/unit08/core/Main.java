package javaConcurrentcy.chapter07.unit08.core;

import javaConcurrentcy.chapter07.unit08.task.Task;

import java.util.concurrent.ForkJoinPool;

public class Main {
	public static void main(String[] args) {
		int[] array = new int[10000];
		
		// 创建一个执行池
		ForkJoinPool pool = new ForkJoinPool();
		
		// 创建一个任务对象
		Task task = new Task("Task", array, 0, array.length);
		
		// 把任务提交到执行池
		pool.invoke(task);
//		pool.submit(task);
//		pool.execute(task);
		
		// 关闭执行池
		pool.shutdown();
		
		// 输出信息，表明程序执行结束
        System.out.printf("Main: End of the program.\n");
	}
}
