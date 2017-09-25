package cn.cc.myspring.proprety;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestRun {

	
	@Autowired
	private HomeProperties homeProperties;
	
	@Autowired
	private UserProperties userProperties;
	
	@Scheduled(fixedDelay=1000)
	public void run() {
		System.out.println(homeProperties.toString());
		System.out.println(userProperties.toString());
	}
	
}
