package javaConcurrentcy.chapter04.unit06.core;

import javaConcurrentcy.chapter04.unit06.task.Result;
import javaConcurrentcy.chapter04.unit06.task.Task;

import java.util.*;
import java.util.concurrent.*;

public class Main {

	public static void main(String[] args) {
		// 使用Executors类的newCachedThreadPool()方法，创建ThreadPoolExecutor对象。
        ExecutorService executor = Executors.newCachedThreadPool();
        
        // 创建三个Task对象，并且将他们存储在一个链表当中
        List<Task> tasks = new ArrayList<>();
        for (int i=0; i<3; i++) {
        	Task task = new Task("Taks " +i);
        	tasks.add(task);
        }
        
        // 创建Future对象列表，参数化为Result类型。
        List<Future<Result>> results = null;
        try {
        	// 调用ThreadPoolExecutor类的invokeAll()方法。这个类将会返回之前创建的Future对象列表。
        	results = executor.invokeAll(tasks);
        } catch (InterruptedException e) {
        	e.printStackTrace();
		}
        
        // 使用shutdown()方法结束执行器的执行。
        executor.shutdown();
        
        // 将结果写入控制台
        System.out.printf("Core: Printing the results\n");
        for (Future<Result> future : results) {
        	try {
        		Result result = future.get();
        		System.out.printf("%s: %s\n", result.getName(), result.getValue());
        	} catch (InterruptedException | ExecutionException e) {
        		e.printStackTrace();
			}
        }
	}

}
