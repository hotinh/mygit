package cn.cc.mp.wb;

import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import cn.cc.mp.wb.dao.DictMapper;
import cn.cc.mp.wb.model.Dict;
import tk.mybatis.mapper.entity.Condition;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

public class Tesfdfd extends Tester {

    @Resource
    private DictMapper dictMapper;
    
    @Resource
    @Qualifier("dictCache")
    private CacheManager dictCache;
    
    @SuppressWarnings("unchecked")
    @Test
    public void dfr() {
        List<Dict> list = null;
        
        Cache cache = dictCache.getCache("nation");
        Cache.ValueWrapper valueWrapper = cache.get("nation");
        
        if (valueWrapper != null) {
            list = (List<Dict>) valueWrapper.get();
        }
        
        if (list == null) {
            Condition conditon = new Condition(Dict.class);
            conditon.createCriteria().andCondition("type='nation'");
            list = dictMapper.selectByCondition(conditon);
        }
        
        log.info("size:{}", list.size());
    }
    
    @Test
    public void sdf() {
        List<Dict> list = dictMapper.selectAll();
        
        Map<String, List<Dict>> sf = list.stream().collect(Collectors.groupingBy(Dict :: getType));
        
        log.info("size:{}", sf.size());
        
//       list.forEach(e -> {
//           log.info("e:{}", e);
//       });
       
       sf.forEach((e, val) ->{
           log.info("{}={}", e, val);
       });
    }
    
    @Test
    public void sss() {
        log.info("--------------");
    }
    
}
