package cn.cc.myspring.helloworld;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HelloWorldController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

	@RequestMapping("/")
	public String sayHello() {
		logger.info("---,");
		return "Hello World!";
	}
}
