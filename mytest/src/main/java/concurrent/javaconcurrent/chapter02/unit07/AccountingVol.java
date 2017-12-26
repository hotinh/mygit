package concurrent.javaconcurrent.chapter02.unit07;

public class AccountingVol implements Runnable {
	static AccountingVol instance = new AccountingVol();
	static volatile int i=0;
	public  void increase() {
		i++;
	}
	
	@Override
	public void run() {
		for (int j=0; j<10000;j++) {
			increase();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(instance);
		Thread t2 = new Thread(instance);
		t1.start();t2.start();
		t1.join();t2.join();
		System.out.println(i);
	}

}
