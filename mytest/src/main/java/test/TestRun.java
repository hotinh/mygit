package test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestRun {

	public final static long ONE_Minute =  5 * 1000;
	
	@Scheduled(fixedDelay=ONE_Minute)
	public void run() {
		System.out.println("run...");
	}
	
}
