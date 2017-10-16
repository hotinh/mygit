package javaConcurrentcy.chapter04.unit12.task;

import java.util.concurrent.TimeUnit;

/**
 * 任务类，执行一个随机时间的任务
 */
public class Task implements Runnable {
    /**
     * 任务的名称
     */
    private String name;

    /**
     * 构造函数，初始化任务名称
     *
     * @param name 任务名称
     */
    public Task(String name) {
        this.name = name;
    }

    /**
     * 核心方法，向控制台输出当前执行的时间
     */
    @Override
    public void run() {
    	System.out.printf("Task %s: Starting\n", name);
    	try {
    		Long duration = (long)(Math.random()*10);
    		System.out.printf("Task %s: ReportGenerator: Generating a report during %d seconds\n",
    				name, duration);
    		TimeUnit.SECONDS.sleep(duration);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
		}
    	System.out.printf("Task %s: Ending\n", name);
    }
    
    @Override
    public String toString() {
    	return name;
    }
}