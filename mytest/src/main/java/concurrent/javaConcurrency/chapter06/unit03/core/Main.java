package concurrent.javaConcurrency.chapter06.unit03.core;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import concurrent.javaConcurrency.chapter06.unit03.task.Client;

public class Main {

	public static void main(String[] args) throws Exception {
		// 创建一个并发链式双向队列
		LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>(3);
		
		Client client = new Client(list);
		Thread thread = new Thread(client);
		thread.start();
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<3; j++) {
				String request = list.take();
				System.out.printf("Main: Request: %s at %s. Size: %d\n", request, new Date(), list.size());
			}
			TimeUnit.MILLISECONDS.sleep(300);
		}
		System.out.printf("Main: End of the program");
	}

}
