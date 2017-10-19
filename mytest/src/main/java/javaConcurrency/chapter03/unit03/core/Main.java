package javaConcurrency.chapter03.unit03.core;

import javaConcurrency.chapter03.unit03.task.PrintQueue;
import javaConcurrency.chapter03.unit03.task.Job;

public class Main {

	public static void main(String[] args) {
		// 创建一个打印对队对象
		PrintQueue printQueue = new PrintQueue();
		
		// 创建12个线程，运行作业任务，这些任务都向同一个打印队列对象发出打印请求
		Thread[] threads = new Thread[12];
		for (int i=0; i<12; i++) {
			threads[i] = new Thread(new Job(printQueue), "Thread " + i);
		}
		
		// 启动12个线程
		for (int i=0; i<12; i++) {
			threads[i].start();
		}
	}
}
