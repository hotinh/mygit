package javaConcurrentcy.chapter01.unit08.core;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;

import javaConcurrentcy.chapter01.unit08.event.Event;
import javaConcurrentcy.chapter01.unit08.task.CleanerTask;
import javaConcurrentcy.chapter01.unit08.task.WriterTask;

public class Main {

	public static void main(String[] args) {
		Deque<Event> deque = new ArrayDeque<Event>();
		
		WriterTask writer = new WriterTask(deque);
		for (int i=0; i<3; i++) {
			Thread thread = new Thread(writer);
			thread.start();
		}
		
		CleanerTask cleaner = new CleanerTask(deque);
		cleaner.start();
	}
	
}
