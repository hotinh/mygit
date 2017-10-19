package javaConcurrency.chapter04.unit05.core;

import javaConcurrency.chapter04.unit05.task.UserValidator;
import javaConcurrency.chapter04.unit05.task.TaskValidator;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// 创建两个String对象，一个名为name，另一个名为password，使用”test”值初始化它们。
		String username = "test";
		String password = "test";
		
		// 创建两个UserValidator对象，一个名为ldapValidator，另一个名为dbValidator。
		UserValidator ldapValidator = new UserValidator("LDAP");
		UserValidator dbValidator = new UserValidator("DataBase");
		
		// 创建两个TaskValidator对象，分别为ldapTask和dbTask。分别使用ldapValidator和dbValidator初始化它们。
		TaskValidator ldapTask = new TaskValidator(ldapValidator, username, password);
		TaskValidator dbTask = new TaskValidator(dbValidator, username, password);
		
		// 创建TaskValidator队列，添加两个已创建的对象（ldapTask和dbTask）
		List<TaskValidator> tasks = new ArrayList<>();
		tasks.add(ldapTask);
		tasks.add(dbTask);
		
		// 使用Executors类的newCachedThreadPool()方法创建一个新的ThreadPoolExecutor对象和一个类型为String，
        // 名为result的变量。
		ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool();
		String result;
		try {
			// 调用executor对象的invokeAny()方法。该方法接收taskList参数，返回String类型。
            // 同样，它将该方法返回的String对象写入到控制台。
			result = executor.invokeAny(tasks);
			 System.out.printf("Main: Result: %s\n", result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		 // 使用shutdown()方法结束执行者，写入一条信息到控制台，表明程序已结束。
		executor.shutdown();
		System.out.printf("Main: End of the Execution\n");
	}

}
