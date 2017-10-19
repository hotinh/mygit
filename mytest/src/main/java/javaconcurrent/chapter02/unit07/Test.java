package javaconcurrent.chapter02.unit07;

public class Test {
	static volatile  int i=0;
	static Object obj = new Object();
	
	public static class AccountingVol implements Runnable {
		public void increase() {
			i++;
		}
		
		@Override
		public void run() {
			synchronized (obj) {
				for (int j=0; j<10000;j++) {
					increase();
				}
			}
		}
	}
	
	public static class AccountingVol2 implements Runnable {
		public void increase() {
			i++;
		}
		
		@Override
		public void run() {
			synchronized (obj) {
				for (int j=0; j<10000;j++) {
					increase();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new AccountingVol());
		Thread t2 = new Thread(new AccountingVol2());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}
	
}
