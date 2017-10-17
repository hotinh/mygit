package javaConcurrentcy.chapter06.unit03.task;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * 向阻塞队列中添加数据的类
 */
public class Client implements Runnable {

	private LinkedBlockingDeque<String> requestList;
	
	public Client(LinkedBlockingDeque<String> requestList) {
		this.requestList = requestList;
	}

	/**
     * 核心方法，添加15个对象
     */
	@Override
	public void run() {
		for (int i=0; i<3; i++) {
			for (int j=0; j<5; j++) {
				StringBuilder request = new StringBuilder();
				request.append(i);
				request.append(":");
				request.append(j);
				try {
					requestList.put(request.toString());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("Client: %s at %s.\n", request, new Date());
			}
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Client: End.\n");
	}
}
