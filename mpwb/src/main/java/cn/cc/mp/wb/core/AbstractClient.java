package cn.cc.mp.wb.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractClient {
    
    public static final String USER = "/user";

    @Autowired
    public RestTemplate restTemplate;
    
    
    
}
