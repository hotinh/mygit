package concurrent.javaConcurrency.chapter05.unit06.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

import concurrent.javaConcurrency.chapter05.unit06.utils.SearchNumberTask;

/**
 * 任务管理类
 */
public class TaskManager {
	
	private List<ForkJoinTask<Integer>> tasks;
	
	public TaskManager() {
		this.tasks = new ArrayList<>();
	}

	public void addTask(ForkJoinTask<Integer> task) {
		tasks.add(task);
	}
	
	public void cancelTasks(ForkJoinTask<Integer> cancelTask) {
		for (ForkJoinTask<Integer> task : tasks) {
			if (task != cancelTask) {
				task.cancel(true);
				((SearchNumberTask)task).writeCancelMessage();
			}
		}
	}

}
