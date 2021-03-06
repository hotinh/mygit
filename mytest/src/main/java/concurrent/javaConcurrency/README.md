#chapter01-unit02-线程的创建和运行
```
public class Calculator implements Runnable {
 ...
}
Calculator calculator = new Calculator(i);
Thread thread = new Thread(calculator);
thread.start();
```
#chapter01-unit03-线程信息的获取和设置
#chapter01-unit04-线程的中断
```
public class PrimeGenerator extends Thread {
	@Override
	public void run() {
		long number = 1L;
		while (true) {
			// 对每个数字，计算它是不是一个质数，如果是的话就打印到控制台
			if (isPrime(number)) {
				System.out.printf("Number %d is Prime\n", number);
			}
			// 当被中断时，输出一条消息，并且退出方法
			if (isInterrupted()) {
				System.out.printf("The Prime Generator has been Interrupted\n");
				return;
			}
			number++;
		}
	}
}
public class Main {
	Thread task = new PrimeGenerator();
	task.start(); // 启动质数生成线程
	task.interrupt(); 
}
```
#chapter01-unit05-线程中断的控制
```
throws InterruptedException
```
#chapter01-unit06-线程的休眠和恢复
#chapter01-unit07-等待线程的终止
```
thread.join()
```
#chapter01-unit08-守护线程的创建和运行
```
```
#chapter01-unit09-线程中不可控异常的处理
```
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
 @Override
 public void uncaughtException(Thread t, Throwable e) {
  ...
 }
}
thread.setUncaughtExceptionHandler(new ExceptionHandler());
```
#chapter01-unit10-线程布局变量的使用
#chapter01-unit11-线程分组
#chapter01-unit12-线程组中不可控制异常的处理
#chapter01-unit13-使用工厂类创建线程

#chapter02-unit01-使用synchronized实现同步方法-问题
#chapter02-unit02-使用synchronized实现同步方法-问题解决
#chapter02-unit03-使用非依赖属性实现同步
```
synchronized(object){
...
}
```
#chapter02-unit04-在同步代码中使用条件
#chapter02-unit05-用锁实现同步(重入锁)
```
ReentrantLock();
```
#chapter02-unit06-使用读写锁实现同步数据访问
```
ReadWriteLock()
```
#chapter02-unit07-修改锁的公平性
#chapter02-unit08-在锁中使用多条件
```
Condition c1 = lock.newCondition();
Condition c2 = lock.newCondition();

lock.lock();
try {
 while(true){
  c1.await();
 }
 c2.signalAll();
} finally {
 lock.unlock();
}
```
#chapter02-unit09-应用例子

#chapter03-unit02-资源并发控制访问
```
Semaphore semaphore
```
#chapter03-unit03-资源的多副本的并发访问控制
```
Semaphore semaphore
ReentrantLock();
```
#chapter03-unit04-等待多个并发事件的完成
```
CountDownLatch
```
#chapter03-unit05-在集合点的同步
```
CyclicBarrier
```
#chapter03-unit06-并发阶段任务的运行
```
Phaser
```
#chapter03-unit07-并发阶段任务中的阶段切换
```
MyPhaser extends Phaser {
 protected boolean onAdvance(int phase, int registeredParties) {
  ...
 }
}
```
#chapter03-unit08-并发任务间的数据交换
```
Exchanger
```

#chapter04-unit02-创建线程执行器
```
ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
```
#chapter04-unit03-创建固定大小的线程执行器
```
ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
```
#chapter04-unit04-在执行器中执行任务并返回结果
```
public class FactorialCalculator implements Callable<Integer> {}
ThreadPoolExecutor executor ...
Future<Integer> result = executor.submit(calculator);
```
#chapter04-unit05-运行多个任务并且处理第一个结果
```
executor.invokeAny(tasks);
```
#chapter04-unit06-运行多个任务并且处理所有结果
```
results = executor.invokeAll(tasks);
```
#chapter04-unit07-在执行器中延时执行任务
```
executor.schedule(task, i+1, TimeUnit.SECONDS);
executor.awaitTermination(1, TimeUnit.DAYS);
```
#chapter04-unit08-在执行器中周期性执行任务
```
ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
System.out.printf("Main: Delay: %d\n", result.getDelay(TimeUnit.MILLISECONDS));
```
#chapter04-unit09-在执行器中取消任务
```
Future<String> result = executor.submit(task);
result.cancel(true);
```
#chapter04-unit10-在执行器中控制任务的完成
```
!resultTask.isCancelled()
```
#chapter04-unit11-在执行器中分离任务的启动与结果的处理
```
CompletionService
```
#chapter04-unit12-处理在执行器中被拒绝的任务
```
ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
executor.setRejectedExecutionHandler(controller);
```

#chapter05-unit02-创建Fork-Join线程池
```
ForkJoinPool pool = new ForkJoinPool();
public class Task extends RecursiveAction {}
```
#chapter05-unit03-合并任务的结果
```
RecursiveTask
```
#chapter05-unit04-异步运行任务
#chapter05-unit05-在任务中抛出异常
#chapter05-unit06-取消任务

#chapter06-unit02-使用非阻塞式线程安全列表
```
ConcurrentLinkedDeque
```
#chapter06-unit03-使用阻塞式线程安全列表
```
LinkedBlockingDeque
```
#chapter06-unit04-使用按优先级排序的阻塞式线程安全列表
```
PriorityBlockingQueue
```
#chapter06-unit05-使用带有延迟元素的线程安全列表
```
DelayQueue
```
#chapter06-unit06-使用线程安全可遍历映射
```
ConcurrentSkipListMap
```
#chapter06-unit07-生成并发随机数
```
ThreadLocalRandom
```
#chapter06-unit08-使用原子变量
```
AtomicLong
```
#chapter06-unit09-使用原子数组
```
AtomicIntegerArray
```

#chapter07-unit02-定制ThreadPoolExecutor类
```
```
#chapter07-unit03-基于优先级的Executor类
```
```
#chapter07-unit04-实现ThreadFactory接口生成定制线程
```
```
#chapter07-unit05-在Executor对象中使用ThreadFactory
```
```
#chapter07-unit06-定制运行在线程池中的任务
```
public class MyScheduledTask<V> extends FutureTask<V> implements RunnableScheduledFuture<V> {}
public class MyScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {}
```
#chapter07-unit07-通过实现ThreadFactory接口为Fork-Join框架
```
```
#chapter07-unit08-定制运行在Fork-Join框架中的任务
```
```
#chapter07-unit09-实现定制Lock类
```
```
#chapter07-unit10-实现基于优先级的传输队列
```
```
#chapter07-unit11-实现自己的原子对象
