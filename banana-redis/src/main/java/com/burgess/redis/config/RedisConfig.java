package com.burgess.redis.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

/**
 * @project banana-redis
 * @package com.burgess.redis.config
 * @file RedisConfig.java
 * @author burgess.zhang
 * @time 22:08:41/2018-09-20
 * @desc redis config 配置
 */
@Configuration
public class RedisConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(RedisConfig.class);

	/**
	 * @file RedisConfig.java
	 * @author burgess.zhang
	 * @time 22:12:21/2018-09-20
	 * @desc jedis连接池
	 * @param config
	 * @param host
	 * @param port
	 * @param password
	 * @return
	 */
	@Bean(name = "jedisPool")
	@Autowired
	public JedisPool jedisPool(@Qualifier("jedis.pool.config") JedisPoolConfig config,
			@Value("${jedis.pool.host}") String host, @Value("${jedis.pool.port}") int port,
			@Value("${jedis.pool.password}") String password) {
		LOGGER.info("缓存服务器的地址：" + host + ":" + port);
		return new JedisPool(config, host, port, Protocol.DEFAULT_TIMEOUT, password);
	}

	/**
	 * @file RedisConfig.java
	 * @author burgess.zhang
	 * @time 22:12:49/2018-09-20
	 * @desc jedis配置
	 * @param maxTotal
	 * @param maxIdle
	 * @param maxWaitMillis
	 * @return
	 */
	@Bean(name = "jedis.pool.config")
	public JedisPoolConfig jedisPoolConfig(@Value("${jedis.pool.config.maxTotal}") int maxTotal,
			@Value("${jedis.pool.config.maxIdle}") int maxIdle,
			@Value("${jedis.pool.config.maxWaitMillis}") int maxWaitMillis) {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(maxTotal);
		config.setMaxIdle(maxIdle);
		config.setMaxWaitMillis(maxWaitMillis);
		return config;
	}

}
