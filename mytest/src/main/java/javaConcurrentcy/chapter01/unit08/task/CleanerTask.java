package javaConcurrentcy.chapter01.unit08.task;

import java.util.Date;
import java.util.Deque;

import javaConcurrentcy.chapter01.unit08.event.Event;

/**
 * 事件清除类，每隔10s从队尾取出一个事件，并且删除这个事件
 */
public class CleanerTask extends Thread {

	/**
	 * 用于存储事件对象的队列
	 */
	Deque<Event> deque;

	/**
	 * 构造函数
	 * 
	 * @param deque 存储事件对象的队列
	 */
	public CleanerTask(Deque<Event> deque) {
		this.deque = deque;
		setDaemon(true); //表明当前对象是一个守护线程
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.printf("delete");
			Date date = new Date();
			clean(date);
		}
	}
	
	/**
	 * 清除方法，生存时间长于10s的事件进行清除
	 * @param date 当前时间
	 */
	private void clean(Date date) {
		long difference;
		boolean delete;
		
		if(this.deque.size() == 0) {
			return;
		}
		
		delete = false;
		do {
			Event e = this.deque.getLast();
			difference = date.getTime() - e.getDate().getTime(); // 计算最早的事件距离现在的时间
			
			if (difference > 10000) { // 大于10秒就输出信息，并且删除最先发生的事件
				System.out.printf("Clearner: %s\n", e.getEvent());
				deque.removeLast();
				delete = true;
			}
		} while(difference > 10000);
		
		if (delete) { // 有删除就出输出删除后队列的大小
			System.out.printf("Clearner: Size of the queue: %d\n", deque.size());
		}
	}
}
