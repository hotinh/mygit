package concurrent.javaConcurrency.chapter01.unit10.core;

import java.util.concurrent.TimeUnit;

import concurrent.javaConcurrency.chapter01.unit10.task.SafeTask;

public class SafeMain {

	public static void main(String[] args) {
		// 创建线程安全的任务
		SafeTask task = new SafeTask();
		
		// 将任务入进不同的线程中
		for (int i=0; i<3; i++) {
			Thread thread = new Thread(task);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
