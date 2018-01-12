package cn.cc.mp.wb.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class ResultHelper {
    final static Logger logger = LoggerFactory.getLogger(ResultHelper.class);

    public static Map<String, Object> build(Object... vars) {
        Map<String, Object> map = new HashMap<>();
        for(int i = 0; i < vars.length; i+=2) {
            map.put(vars[i].toString(), vars[i+1]);
        }
        return map;
    }
    
    public static void responseResult(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

}
