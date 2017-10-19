package javaconcurrent.chapter02.unit02;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
	
	static volatile int i=0;
	static Lock lock = new ReentrantLock();
	static Object obj = new Object();
	
	public static class PlusTask implements Runnable {
		@Override
		public void run() {
//			lock.lock();
			synchronized (Test.class) {
				for (int k=0; k<10000; k++) {
					i++;
				}
			}
//			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[10];
		for (int i=0;i<10; i++) {
			threads[i]=new Thread(new PlusTask());
			threads[i].start();
		}
		for (int i=0;i<10; i++) {
			threads[i].join();
		}
		System.out.println(i);
	}
}
