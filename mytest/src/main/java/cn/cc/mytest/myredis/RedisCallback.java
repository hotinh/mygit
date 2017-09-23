package cn.cc.mytest.myredis;

import redis.clients.jedis.Jedis;

public interface RedisCallback<T> {
	  public T handle(Jedis jedis);
	}
