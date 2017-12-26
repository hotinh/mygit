package concurrent.javaConcurrency.chapter04.unit09.task;

import java.util.concurrent.Callable;

/**
 * 任务类，执行任务
 */
public class Task implements Callable<String> {
	/**
     * 核心方法，一个无限循环的任务，每100毫秒向控制台写一个消息
     * @return
     * @throws Exception
     */
	@Override
	public String call() throws Exception {
		while (true){
            System.out.printf("Task: Test\n");
            Thread.sleep(100);
        }
	}
}