package com.burgess.redis.service;

import redis.clients.jedis.Jedis;

/**
 * @project banana-redis
 * @package com.burgess.redis.service
 * @file RedisService.java
 * @author burgess.zhang
 * @time 22:52:11/2018-09-20
 * @desc redis service 接口
 */
public interface RedisService {

	/**
	 * @file RedisService.java
	 * @author burgess.zhang
	 * @time 22:57:58/2018-09-20
	 * @desc  获取Jedis对象 
	 * @return
	 */
	Jedis getJedis();
	
	/**
	 * @file RedisService.java
	 * @author burgess.zhang
	 * @time 22:57:48/2018-09-20
	 * @desc 回收Jedis对象资源 
	 * @param jedis
	 */
	void returnResource(Jedis  jedis);
	
	/**
	 * @file RedisService.java
	 * @author burgess.zhang
	 * @time 22:57:37/2018-09-20
	 * @desc Jedis对象出异常的时候，回收Jedis对象资源 
	 * @param jedis
	 */
	void returnBrokenResource(Jedis  jedis);
}
