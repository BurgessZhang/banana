package com.burgess.common.map;

import java.util.Map;

/**
 * @project banana-common
 * @package com.burgess.common.map
 * @file MapUtils.java
 * @author burgess.zhang
 * @time 下午2:03:46/2018年8月30日
 * @desc map 工具类型
 */
public class MapUtils {

	/**
	 * @file MapUtils.java
	 * @author burgess.zhang
	 * @time 下午2:05:55/2018年8月30日
	 * @desc 校验map为null
	 * @param map
	 * @return
	 */
	public static <K, V> boolean isBlank(Map<K, V> map) {
		if (null == map || map.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * @file MapUtils.java
	 * @author burgess.zhang
	 * @time 下午2:07:27/2018年8月30日
	 * @desc 校验map不为null
	 * @param map
	 * @return
	 */
	public static <K, V> boolean isNotBlank(Map<K, V> map) {
		return !isBlank(map);
	}

}
