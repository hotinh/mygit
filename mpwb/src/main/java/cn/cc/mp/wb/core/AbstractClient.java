package cn.cc.mp.wb.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractClient {
    
    protected Logger logger = LoggerFactory.getLogger(AbstractClient.class);
    
    public static final String USER = "/user";

    @Autowired
    public RestTemplate restTemplate;
    
    
    
}
