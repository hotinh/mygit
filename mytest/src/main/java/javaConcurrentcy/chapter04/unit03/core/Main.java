package javaConcurrentcy.chapter04.unit03.core;

import javaConcurrentcy.chapter04.unit03.task.Server;
import javaConcurrentcy.chapter04.unit03.task.Task;

public class Main {

	public static void main(String[] args) {
		Server server = new Server();
		
		// 发送100个任务到服务器对象，并且完成任务
		for (int i=0; i<100; i++) {
			Task task = new Task("Task " + i);
			server.executorTask(task);
		}
		
		server.endServer();
	}
}
