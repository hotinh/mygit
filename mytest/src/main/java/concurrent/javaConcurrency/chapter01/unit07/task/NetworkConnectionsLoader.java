package concurrent.javaConcurrency.chapter01.unit07.task;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 网络连接加载器，模拟网络连接，它会休眠6s
 * @author Administrator
 *
 */
public class NetworkConnectionsLoader implements Runnable {

	@Override
	public void run() {
		// 输出一条消息
		System.out.printf("Beginning network connections loading: %s\n", new Date());
		
		// 休眠10s
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 输出一条消息
		System.out.printf("Network connections loading has finished: %s\n", new Date());
	}

}
