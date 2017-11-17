package cn.cc.myspring.rest;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfig.class)
public class TestRest {
	
	static RestTemplate restTemplate = new RestTemplate();
	
	static Logger logger = Logger.getLogger(TestRest.class);
	
	public static void main(String[] args) {
		String url = "http://192.168.0.113:8088/alarms/1";
		String result = 
		restTemplate.getForObject(url, String.class);
		
		
		//RestClient.getClient().getForObject(url, String.class);
		
		logger.info(result);
	}
	
	@Test
	public void test() {
		String url = "http://192.168.0.113:8088/alarms/1";
		String result = 
		restTemplate.getForObject(url, String.class);
		
		
		//RestClient.getClient().getForObject(url, String.class);
		
		logger.info(result);
		
	}

}
