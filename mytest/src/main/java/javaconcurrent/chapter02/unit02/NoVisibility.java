package javaconcurrent.chapter02.unit02;

import org.h2.engine.SysProperties;

public class NoVisibility {

	private static boolean ready;
	private static int number;
	
	private static class ReaderThread extends Thread {
		public void run() {
			while (!ready) {
				System.out.println(number);
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		new ReaderThread().start();
		Thread.sleep(100);
		number = 42;
		ready = true;
		Thread.sleep(1000);
	}
}
