package cn.cc.mytest.myredis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTools {

	private static JedisPool jedisPool = null;
	private static Jedis jedis;
	 
	static {
	  jedis = getJedisPool().getResource();
	}
	 
	/**
	 * 构建redis连接池
	 */
	public static JedisPool getJedisPool() {
	  if (jedisPool == null) {
	    JedisPoolConfig config = new JedisPoolConfig();
	    config.setMaxTotal(1024); // 可用连接实例的最大数目,如果赋值为-1,表示不限制.
	    config.setMaxIdle(5); // 控制一个Pool最多有多少个状态为idle(空闲的)jedis实例,默认值也是8
	    config.setMaxWaitMillis(1000 * 100); // 等待可用连接的最大时间,单位毫秒,默认值为-1,表示永不超时/如果超过等待时间,则直接抛出异常
	    config.setTestOnBorrow(true); // 在borrow一个jedis实例时,是否提前进行validate操作,如果为true,则得到的jedis实例均是可用的
	    jedisPool = new JedisPool(config, "127.0.0.1", 6379);
	  }
	  return jedisPool;
	}
	 
	/**
	 * 释放jedis资源
	 */
	public static void returnResource(Jedis jedis) {
	  if (jedis != null) {
	    jedis.close();
	  }
	}
}
