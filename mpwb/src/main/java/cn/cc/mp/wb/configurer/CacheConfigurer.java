package cn.cc.mp.wb.configurer;

import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.cc.mp.wb.dao.DictMapper;
import cn.cc.mp.wb.dao.UserMapper;
import cn.cc.mp.wb.model.Dict;
import cn.cc.mp.wb.model.User;

@Configuration
@EnableCaching
public class CacheConfigurer {
    
    @Resource
    private DictMapper dictMapper;
    @Resource
    private UserMapper userMapper;
    
    @Bean("dictCache")
    public CacheManager dictCache() {
        GuavaCacheManager cacheManager = new GuavaCacheManager();
        
        /*List<Dict> list = dictMapper.selectAll();
        
        //最多缓存500 条，失效时间30分钟 
        cacheManager.setCacheSpecification("maximumSize=500,expireAfterWrite=30m");
        //GuavaCacheManager 的数据结构类似  Map<String,Map<Object,Object>>  map =new HashMap<>();

        //所有缓存的名字
        List<String> cacheNames = new ArrayList<>();
        
        //将数据放入缓存
        Map<String, List<Dict>> sf = list.stream().collect(Collectors.groupingBy(Dict :: getType));
        
        sf.forEach((key, value) -> {
            if(cacheManager.getCache(key)==null){
                cacheNames.add(key);
                cacheManager.setCacheNames(cacheNames);
            }
            Cache cache = cacheManager.getCache(key);
            cache.put(key, value);
        });*/
        
        return cacheManager;
    }
    
    /*@Bean("userCache")
    public CacheManager userCache() {
        List<User> list = userMapper.selectAll();
        List<String> cacheNames = new ArrayList<>();
        GuavaCacheManager cacheManager = new GuavaCacheManager();

        //最多缓存500 条，失效时间30分钟 
        cacheManager.setCacheSpecification("maximumSize=500,expireAfterWrite=30m");
        //GuavaCacheManager 的数据结构类似  Map<String,Map<Object,Object>>  map =new HashMap<>();

        //将数据放入缓存
        list.stream().forEach(user -> {
            //用person 的id cacheName
            String cacheName = user.getId().toString();
            if(cacheManager.getCache(cacheName) == null) {
                //为每一个person 如果不存在，创建一个新的缓存对象
                cacheNames.add(cacheName);
                cacheManager.setCacheNames(cacheNames);
            }
            Cache cache = cacheManager.getCache(cacheName);
            //缓存对象用person的id当作缓存的key 用person 当作缓存的value
            cache.put(user.getId(), user);
            //System.out.println("为 ID 为"+cacheName+ "的person 数据做了缓存");
        });
        return cacheManager;
    }*/

}
