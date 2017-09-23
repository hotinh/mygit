package cn.cc.mytest.myredis;

import redis.clients.jedis.Jedis;

public class Test {

	public static String getByTemplate(final String key) {
		  RedisTemplate redisTemplate = new RedisTemplate(RedisTools.getJedisPool());
		  String value = redisTemplate.execute(new RedisCallback<String>() {
		    @Override
		    public String handle(Jedis jedis) {
		      return jedis.get(key);
		    }
		  });
		  return value;
		}
	
	
}
