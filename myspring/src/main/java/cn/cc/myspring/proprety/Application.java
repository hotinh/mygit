package cn.cc.myspring.proprety;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.slf4j.*;

@SpringBootApplication
@EnableScheduling
public class Application  {
	
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
//	@Autowired
//	private HomeProperties homeProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("---" + homeProperties.toString());
//	}
}
