package javaConcurrentcy.chapter01.unit10.task;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {
	
	private Date startDate;

	@Override
	public void run() {
		this.startDate = new Date();
		System.out.printf("Starting Thread %s : %s\n", Thread.currentThread().getId(), startDate);
		
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate);
	}

}
