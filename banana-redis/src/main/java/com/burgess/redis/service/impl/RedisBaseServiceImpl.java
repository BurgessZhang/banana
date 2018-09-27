package com.burgess.redis.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burgess.redis.service.RedisBaseService;
import com.burgess.redis.service.RedisService;

import redis.clients.jedis.Jedis;

/**
 * @project banana-redis
 * @package com.burgess.redis.service.impl
 * @file RedisBaseServiceImpl.java
 * @author burgess.zhang
 * @time 22:33:04/2018-09-20
 * @desc redis基础操作service接口实现
 */
@Service
public class RedisBaseServiceImpl implements RedisBaseService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RedisBaseServiceImpl.class);

	@Autowired
	private RedisService redisService;

	/**
	 * @file RedisBaseServiceImpl.java
	 * @author burgess.zhang
	 * @time 22:33:05/2018-09-20
	 * @desc 验证key是否存
	 * @param key
	 * @return
	 * @see com.burgess.redis.service.RedisBaseService#exists(java.lang.String)
	 */
	@Override
	public boolean exists(String key) {
		if (StringUtils.isBlank(key)) {
			LOGGER.error("[class: RedisBaseServiceImpl.java]-[method: exists]-[function: {}]-[params: key]-[结果: {}]",
					"验证key是否存", key);
			return false;
		}
		Jedis jedis = redisService.getJedis();
		boolean mark = jedis.exists(key);
		redisService.returnResource(jedis);
		return mark;
	}

	/**
	 * @file RedisBaseServiceImpl.java
	 * @author burgess.zhang
	 * @time 22:33:05/2018-09-20
	 * @desc 删除key
	 * @param key
	 * @return
	 * @see com.burgess.redis.service.RedisBaseService#del(java.lang.String)
	 */
	@Override
	public boolean del(String key) {
		if (StringUtils.isBlank(key)) {
			LOGGER.error("[class: RedisBaseServiceImpl.java]-[method: del]-[function: {}]-[params: key]-[结果: {}]",
					"删除key", "key不存在");
			return false;
		}
		Jedis jedis = redisService.getJedis();
		long mark = jedis.del(key);
		redisService.returnResource(jedis);
		if (0 == mark) {
			LOGGER.error("[class: RedisBaseServiceImpl.java]-[method: del]-[function: {}]-[params: key]-[结果: {}]",
					"删除key", "失败!");
			return false;
		}
		return true;
	}

	/**
	 * @file RedisBaseServiceImpl.java
	 * @author burgess.zhang
	 * @time 22:33:05/2018-09-20
	 * @desc 获取key对应的value类型
	 * @param key
	 * @return
	 * @see com.burgess.redis.service.RedisBaseService#type(java.lang.String)
	 */
	@Override
	public String type(String key) {
		if (StringUtils.isBlank(key)) {
			LOGGER.error("[class: RedisBaseServiceImpl.java]-[method: type]-[function: {}]-[params: key]-[结果: {}]",
					"获取key对应的value类型", "key不能为null");
			return null;
		}
		Jedis jedis = redisService.getJedis();
		String type = jedis.type(key);
		redisService.returnResource(jedis);
		return type;
	}

	/**
	 * @file RedisBaseServiceImpl.java
	 * @author burgess.zhang
	 * @time 22:33:05/2018-09-20
	 * @desc 随机生成key
	 * @return
	 * @see com.burgess.redis.service.RedisBaseService#randomKey()
	 */
	@Override
	public String randomKey() {
		Jedis jedis = redisService.getJedis();
		String key = jedis.randomKey();
		redisService.returnResource(jedis);
		LOGGER.info("[class: RedisBaseServiceImpl.java]-[method: randomKey]-[function: {}]-[params:  {}]", "随机生成key",
				key);
		return key;
	}

	/**
	 * @file RedisBaseServiceImpl.java
	 * @author burgess.zhang
	 * @time 22:33:05/2018-09-20
	 * @desc 重名了key
	 * @param oldkey
	 * @param newkey
	 * @return
	 * @see com.burgess.redis.service.RedisBaseService#rename(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public String rename(String oldkey, String newkey) {
		if (StringUtils.isBlank(oldkey) || StringUtils.isBlank(newkey)) {
			LOGGER.error(
					"[class: RedisBaseServiceImpl.java]-[method: rename]-[function: {}]-[params: oldkey, newkey]-[结果: {}]",
					"重名了key", "参数不全!");
			return null;
		}
		Jedis jedis = redisService.getJedis();
		String flag = jedis.rename(oldkey, newkey);
		redisService.returnResource(jedis);
		return flag;
	}

	/**
	 * @file RedisBaseServiceImpl.java
	 * @author burgess.zhang
	 * @time 22:33:05/2018-09-20
	 * @desc 设置key的有效时间
	 * @param key
	 * @param seconds 秒
	 * @return
	 * @see com.burgess.redis.service.RedisBaseService#expire(java.lang.String, int)
	 */
	@Override
	public boolean expire(String key, int seconds) {
		if (StringUtils.isBlank(key)) {
			LOGGER.error(
					"[class: RedisBaseServiceImpl.java]-[method: expire]-[function: {}]-[params: key, seconds]-[结果: {}]",
					"设置key的有效时间", "key不能为null");
			return false;
		}
		if (!exists(key)) {
			LOGGER.error(
					"[class: RedisBaseServiceImpl.java]-[method: expire]-[function: {}]-[params: key, seconds]-[结果: {}]",
					"设置key的有效时间", "key不存在!");
			return false;
		}
		Jedis jedis = redisService.getJedis();
		long flag = jedis.expire(key, seconds);
		redisService.returnResource(jedis);
		if (0 == flag) {
			LOGGER.error(
					"[class: RedisBaseServiceImpl.java]-[method: expire]-[function: {}]-[params: key, seconds]-[结果: {}]",
					"设置key的有效时间", "失败!");
			return false;
		}
		return true;
	}

	/**
	 * @file RedisBaseServiceImpl.java
	 * @author burgess.zhang
	 * @time 22:33:05/2018-09-20
	 * @desc 设置key的有效时间
	 * @param key
	 * @param unixTime 毫秒
	 * @return
	 * @see com.burgess.redis.service.RedisBaseService#expireAt(java.lang.String,
	 *      long)
	 */
	@Override
	public boolean expireAt(String key, long unixTime) {
		if (StringUtils.isBlank(key)) {
			LOGGER.error(
					"[class: RedisBaseServiceImpl.java]-[method: expire]-[function: {}]-[params: key, seconds]-[结果: {}]",
					"设置key的有效时间", "key不能为null");
			return false;
		}
		if (!exists(key)) {
			LOGGER.error(
					"[class: RedisBaseServiceImpl.java]-[method: expire]-[function: {}]-[params: key, seconds]-[结果: {}]",
					"设置key的有效时间", "key不存在!");
			return false;
		}
		Jedis jedis = redisService.getJedis();
		long flag = jedis.expireAt(key, unixTime);
		redisService.returnResource(jedis);
		if (0 == flag) {
			LOGGER.error(
					"[class: RedisBaseServiceImpl.java]-[method: expire]-[function: {}]-[params: key, seconds]-[结果: {}]",
					"设置key的有效时间", "失败!");
			return false;
		}
		return true;
	}

	/**
	 * @file RedisBaseServiceImpl.java
	 * @author burgess.zhang
	 * @time 22:33:05/2018-09-20
	 * @desc 获取key的有效时间
	 * @param key
	 * @return
	 * @see com.burgess.redis.service.RedisBaseService#ttl(java.lang.String)
	 */
	@Override
	public Long ttl(String key) {
		if (StringUtils.isBlank(key)) {
			LOGGER.error(
					"[class: RedisBaseServiceImpl.java]-[method: expire]-[function: {}]-[params: key, seconds]-[结果: {}]",
					"获取key的有效时间", "key不能为null");
			return null;
		}
		if (!exists(key)) {
			LOGGER.error(
					"[class: RedisBaseServiceImpl.java]-[method: expire]-[function: {}]-[params: key, seconds]-[结果: {}]",
					"获取key的有效时间", "key不存在!");
			return null;
		}
		Jedis jedis = redisService.getJedis();
		long time = jedis.ttl(key);
		redisService.returnResource(jedis);
		return time;
	}

	/**
	 * @file RedisBaseServiceImpl.java
	 * @author burgess.zhang
	 * @time 22:33:05/2018-09-20
	 * @desc 将指定key移动到指定数据库
	 * @param key
	 * @param dbIndex
	 * @return
	 * @see com.burgess.redis.service.RedisBaseService#move(java.lang.String,
	 *      java.lang.Integer)
	 */
	@Override
	public boolean move(String key, Integer dbIndex) {
		if (StringUtils.isBlank(key)) {
			LOGGER.error(
					"[class: RedisBaseServiceImpl.java]-[method: expire]-[function: {}]-[params: key, seconds]-[结果: {}]",
					"将指定key移动到指定数据库", "key不能为null");
			return false;
		}
		if (!exists(key)) {
			LOGGER.error(
					"[class: RedisBaseServiceImpl.java]-[method: expire]-[function: {}]-[params: key, seconds]-[结果: {}]",
					"将指定key移动到指定数据库", "key不存在!");
			return false;
		}
		Jedis jedis = redisService.getJedis();
		long flag = jedis.move(key, dbIndex);
		if (0 == flag) {
			LOGGER.error(
					"[class: RedisBaseServiceImpl.java]-[method: move]-[function: {}]-[params: key, dbIndex]-[结果: {}]",
					"将指定key移动到指定数据库", "移动失败!");
			return false;
		}
		return true;
	}

}
