package cn.cc.mytest.mylog;

import org.slf4j.*;

public class LogbackDemo {

	private static Logger log = LoggerFactory.getLogger(LogbackDemo.class);  
    public static void main(String[] args) {  
        log.trace("======trace");  
        log.debug("======debug");  
        log.info("======info");  
        log.warn("======warn");  
        log.error("======error");  
    } 
}
