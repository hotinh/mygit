package javaConcurrency.chapter03.unit02.core;

import javaConcurrency.chapter03.unit02.task.PrintQueue;
import javaConcurrency.chapter03.unit02.task.Job;

public class Main {

	public static void main(String[] args) {
		// 创建一个打印队列对象
		PrintQueue printQueue = new PrintQueue();
		
		// 创建10个线程
		Thread[] threads = new Thread[10];
		for (int i=0; i<10; i++) {
			threads[i] = new Thread(new Job(printQueue), "Thread " + i);
		}
		
		// 启动10个线程
		for (int i=0; i<10; i++) {
			threads[i].start();
		}
	}

}
