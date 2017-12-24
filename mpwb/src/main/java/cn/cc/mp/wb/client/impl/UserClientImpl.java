package cn.cc.mp.wb.client.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.alibaba.fastjson.JSONObject;

import cn.cc.mp.wb.client.UserClient;
import cn.cc.mp.wb.core.AbstractClient;
import cn.cc.mp.wb.model.User;

public class UserClientImpl extends AbstractClient implements UserClient {
    
    static Logger logger = LoggerFactory.getLogger(UserClientImpl.class);
    
    @Value("${test.url}")
    private String url;
    
    public String add(User user) {
        url = url + USER;
        logger.info("url:{}", url);
        Map<String, ?> uriVariables = new HashMap<>();
        
        //实体
        JSONObject params = new JSONObject();
        params.put("", "");
        
        //头
        HttpHeaders headers = new HttpHeaders();
        headers.set("", "");
        
        HttpEntity<JSONObject> requestEntity = new HttpEntity<>(params, headers);
        
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class, uriVariables);
        logger.info("result:{}", result);
        return result.getBody();
    }
    
    public String del(User user) {
        url = USER + "/{id}";
        logger.info("url:{}", url);
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("id", user.getId());
        
        //实体
        JSONObject params = new JSONObject();
        
        //头
        HttpHeaders headers = new HttpHeaders();
        headers.set("", "");
        
        HttpEntity<JSONObject> requestEntity = new HttpEntity<>(params, headers);
        
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class, uriVariables);
        logger.info("result:{}", result);
        return result.getBody();
    }
    
    public String update(User user) {
        url = USER;
        logger.info("url:{}", url);
        Map<String, Object> uriVariables = new HashMap<>();
        
        //实体
        JSONObject params = new JSONObject();
        params.put("id", "");
        
        //头
        HttpHeaders headers = new HttpHeaders();
        headers.set("", "");
        
        HttpEntity<JSONObject> requestEntity = new HttpEntity<>(params, headers);
        
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class, uriVariables);
        logger.info("result:{}", result);
        return result.getBody();
    }
    
    public String list(User user) {
        url = USER;
        logger.info("url:{}", url);
        Map<String, Object> uriVariables = new HashMap<>();
        
        //实体
        JSONObject params = new JSONObject();
        params.put("", "");
        
        //头
        HttpHeaders headers = new HttpHeaders();
        headers.set("", "");
        
        HttpEntity<JSONObject> requestEntity = new HttpEntity<>(params, headers);
        
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class, uriVariables);
        logger.info("result:{}", result);
        return result.getBody();
    }
    
    public String detail(User user) {
        url = USER + "/{id}";
        logger.info("url:{}", url);
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("id", user.getId());
        
        //实体
        JSONObject params = new JSONObject();
        params.put("", "");
        
        //头
        HttpHeaders headers = new HttpHeaders();
        headers.set("", "");
        
        HttpEntity<JSONObject> requestEntity = new HttpEntity<>(params, headers);
        
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class, uriVariables);
        logger.info("result:{}", result);
        return result.getBody();
    }
    
}
