package com.burgess.common.list;

import java.util.List;

/**
 * @project banana-common
 * @package com.burgess.common.list
 * @file ListUtils.java
 * @author burgess.zhang
 * @time 下午1:54:00/2018年8月30日
 * @desc list 工具类
 */
public class ListFactory {

	/**
	 * @file ListUtils.java
	 * @author burgess.zhang
	 * @time 下午1:55:41/2018年8月30日
	 * @desc 校验list是否为NULL或size为0
	 * @param list
	 * @return boolean
	 */
	public static boolean isBlank(List<?> list) {
		if (null == list || list.isEmpty() || 0 == list.size()) {
			return true;
		}
		return false;
	}

	/**
	 * @file ListUtils.java
	 * @author burgess.zhang
	 * @time 下午1:58:31/2018年8月30日
	 * @desc 校验list不为null && size != 0
	 * @param list
	 * @return
	 */
	public static boolean isNotBlank(List<?> list) {
		return !isBlank(list);
	}

}
