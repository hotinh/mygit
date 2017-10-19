package javaConcurrency.chapter01.unit06.core;

import java.util.concurrent.TimeUnit;

import javaConcurrency.chapter01.unit06.task.FileClock;

public class Main {

	public static void main(String[] args) {
		// 创建一个文件时间运行对象，并且将其放入一个线程对中
		FileClock clock = new FileClock();
		Thread thread = new Thread(clock);
		
		// 开始线程
		thread.start();
		try {
			//主线程等待五秒（即 Main 线程）
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 中断线程
		thread.interrupt();
	}
}
