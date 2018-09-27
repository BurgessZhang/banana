package com.burgess.redis.service.impl;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burgess.redis.service.RedisService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @project banana-redis
 * @package com.burgess.redis.service.impl
 * @file RedisServiceImpl.java
 * @author burgess.zhang
 * @time 22:52:53/2018-09-20
 * @desc redis service 接口实现
 */
@Service
public class RedisServiceImpl implements RedisService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RedisServiceImpl.class);

	@Autowired
	private JedisPool jedisPool;

	/**
	 * @file RedisServiceImpl.java
	 * @author burgess.zhang
	 * @time 22:52:53/2018-09-20
	 * @desc 获取Jedis对象
	 * @return
	 * @see com.burgess.redis.service.RedisService#getJedis()
	 */
	@Override
	public synchronized Jedis getJedis() {
		Jedis jedis = null;
		if (Objects.nonNull(jedisPool)) {
			try {
				if (Objects.isNull(jedis)) {
					jedis = jedisPool.getResource();
				}
			} catch (Exception e) {
				LOGGER.error("[class: RedisServiceImpl.java]-[method: getJedis]-[function: {}]-[params: ]-[结果: {}]",
						" 获取Jedis对象 ", e.getMessage());
			}
		}
		return jedis;
	}

	/**
	 * @file RedisServiceImpl.java
	 * @author burgess.zhang
	 * @time 22:58:26/2018-09-20
	 * @desc 回收Jedis对象资源
	 * @param jedis
	 * @see com.burgess.redis.service.RedisService#returnResource(redis.clients.jedis.Jedis)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void returnResource(Jedis jedis) {
		if (Objects.nonNull(jedis)) {
			LOGGER.info("[class: RedisServiceImpl.java]-[method: returnResource]-[function: {}]-[params: jedis {}]",
					"回收Jedis对象资源 ", jedis);
			jedisPool.returnResource(jedis);
		}
	}

	/**
	 * @file RedisServiceImpl.java
	 * @author burgess.zhang
	 * @time 22:58:26/2018-09-20
	 * @desc Jedis对象出异常的时候，回收Jedis对象资源
	 * @param jedis
	 * @see com.burgess.redis.service.RedisService#returnBrokenResource(redis.clients.jedis.Jedis)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void returnBrokenResource(Jedis jedis) {
		if (Objects.nonNull(jedis)) {
			LOGGER.info(
					"[class: RedisServiceImpl.java]-[method: returnBrokenResource]-[function: {}]-[params: jedis {}]",
					"Jedis对象出异常的时候，回收Jedis对象资源 ", jedis);
			jedisPool.returnBrokenResource(jedis);
		}
	}

}
