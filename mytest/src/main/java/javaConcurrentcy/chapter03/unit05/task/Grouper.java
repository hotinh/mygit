package javaConcurrentcy.chapter03.unit05.task;

import javaConcurrentcy.chapter03.unit05.utils.Results;

public class Grouper implements Runnable {

	private Results results;
	
	public Grouper(Results results) {
		this.results = results;
	}

	@Override
	public void run() {
		int finalResult = 0;
		System.out.printf("Grouper: Processing results..\n");
		int data[] = results.getData();
		for (int i=0; i<data.length; i++) {
			finalResult += data[i];
		}
		System.out.printf("Grouper: Total result: %d.\n", finalResult);
	}

}
