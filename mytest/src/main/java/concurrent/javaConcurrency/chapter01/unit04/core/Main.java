package concurrent.javaConcurrency.chapter01.unit04.core;

import java.util.concurrent.TimeUnit;

import concurrent.javaConcurrency.chapter01.unit04.task.PrimeGenerator;

public class Main {

	public static void main(String[] args) {
		Thread task = new PrimeGenerator();
		task.start(); // 启动质数生成线程
		try {
			TimeUnit.SECONDS.sleep(5); // 主线程休眠5s
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		task.interrupt(); //质数生成线程中断
	}

}
