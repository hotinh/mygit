package concurrent.javaconcurrent.chapter02.unit08;

import java.util.ArrayList;
import java.util.Vector;

public class ArrayListMultiThread {

	// 并发会有问题
//	static ArrayList<Integer> a1 = new ArrayList<>();
	
	// Vector 可解决
	static Vector<Integer> a1 = new Vector<>();
	
	public static class AddThread implements Runnable {
		@Override
		public void run() {
			for (int i=0;i<10000;i++) {
				a1.add(i);
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new AddThread());
		Thread t2 = new Thread(new AddThread());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(a1.size());
	}
}
