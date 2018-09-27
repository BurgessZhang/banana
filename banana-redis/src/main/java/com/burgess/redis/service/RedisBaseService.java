package com.burgess.redis.service;

/**
 * @project banana-redis
 * @package com.burgess.redis.service
 * @file RedisBaseService.java
 * @author burgess.zhang
 * @time 22:17:42/2018-09-20
 * @desc  redis基础操作service接口
 */
public interface RedisBaseService {

	/**
	 * @file RedisBaseService.java
	 * @author burgess.zhang
	 * @time 22:23:38/2018-09-20
	 * @desc 验证key是否存在
	 * @param key
	 * @return
	 */
	boolean exists(String key);
	
	/**
	 * @file RedisBaseService.java
	 * @author burgess.zhang
	 * @time 22:24:15/2018-09-20
	 * @desc 删除key
	 * @param key
	 * @return
	 */
	boolean del(String key);
	
	/**
	 * @file RedisBaseService.java
	 * @author burgess.zhang
	 * @time 22:26:27/2018-09-20
	 * @desc 获取key对应的value值类型
	 * @param key
	 * @return
	 */
	String type(String key);
	
	/**
	 * @file RedisBaseService.java
	 * @author burgess.zhang
	 * @time 22:27:11/2018-09-20
	 * @desc 随机生成key
	 * @return
	 */
	String randomKey();
	
	/**
	 * @file RedisBaseService.java
	 * @author burgess.zhang
	 * @time 22:27:48/2018-09-20
	 * @desc 重命名key
	 * @param oldkey key旧名称
	 * @param newkey key新名称
	 * @return
	 */
	String rename(final String oldkey, final String newkey);
	
	/**
	 * @file RedisBaseService.java
	 * @author burgess.zhang
	 * @time 22:28:48/2018-09-20
	 * @desc 设置key的有效时间
	 * @param key
	 * @param seconds 秒
	 * @return
	 */
	boolean expire(final String key, final int seconds);
	
	/**
	 * @file RedisBaseService.java
	 * @author burgess.zhang
	 * @time 22:29:29/2018-09-20
	 * @desc 设置key的有效时间
	 * @param key
	 * @param unixTime 毫秒
	 * @return
	 */
	boolean expireAt(final String key, final long unixTime);
	
	/**
	 * @file RedisBaseService.java
	 * @author burgess.zhang
	 * @time 22:30:13/2018-09-20
	 * @desc 获取key的有效时间
	 * @param key
	 * @return
	 */
	Long ttl(String key);
	
	/**
	 * @file RedisBaseService.java
	 * @author burgess.zhang
	 * @time 22:31:34/2018-09-20
	 * @desc 将指定key移动到指定数据库
	 * @param key
	 * @param dbIndex 数据库编号
	 * @return
	 */
	boolean move(String key,Integer dbIndex);
	
}
