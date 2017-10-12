package javaConcurrentcy.chapter03.unit03.task;

public class Job implements Runnable {

	PrintQueue printQueue;
	
	public Job(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}

	@Override
	public void run() {
		System.out.printf("%s: Going to print a jbo\n",
				Thread.currentThread().getName());
		printQueue.printJob(new Object());
		System.out.printf("%s: The document has been printed\n",
				Thread.currentThread().getName());
	}
}
