package cn.cc.mp.wb.core;

import java.util.HashMap;
import java.util.Map;

public class ResultHelper {

    public static Map<String, Object> build(Object... vars) {
        Map<String, Object> map = new HashMap<>();
        for(int i = 0; i < vars.length; i+=2) {
            map.put(vars[i].toString(), vars[i+1]);
        }
        return map;
    }

}
