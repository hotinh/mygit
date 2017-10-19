package javaConcurrency.chapter07.unit06.task;

import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义任务线程池调度类
 */
public class MyScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {

	public MyScheduledThreadPoolExecutor(int corePoolSize) {
		super(corePoolSize);
	}
	
	/**
     * 装饰方法，将一个RunnableScheduledFuture任务转换成MyScheduledTask任务
     */
	@Override
	protected <V> RunnableScheduledFuture<V> decorateTask(
	        Runnable runnable, RunnableScheduledFuture<V> task) {
		MyScheduledTask myTask = new MyScheduledTask<V>(runnable, null, task, this);
		return myTask;
	}
	
	/**
     * 执行器周期期调度的方法
     */
    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command,
                                                  long initialDelay,
                                                  long period,
                                                  TimeUnit unit) {
        // 使用超类的方法去完成任务
        ScheduledFuture<?> task = super.scheduleAtFixedRate(command, initialDelay, period, unit);
        MyScheduledTask<?> myTask = (MyScheduledTask<?>) task;
        myTask.setPeriod(TimeUnit.MILLISECONDS.convert(period, unit));
        return task;
    }

}
