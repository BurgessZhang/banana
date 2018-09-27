package com.burgess.common.array;

import java.util.Objects;

/**
 * @project banana-common
 * @package com.burgess.common.array
 * @file ArrayFactory.java
 * @author burgess.zhang
 * @time 下午1:30:18/2018年8月30日
 * @desc array工厂
 */
public class ArrayFactory {
	
	//私有化构造方法
	private ArrayFactory() {}
	
	/**
	 * @file ArrayFactory.java
	 * @author burgess.zhang
	 * @time 22:36:42/2018-09-11
	 * @desc 校验数组是否为null
	 * @param array
	 * @return
	 */
	public static <T>  boolean isBlank(T[] array) {
		if (Objects.isNull(array) || 0 == array.length) {
			return true;
		}
		return false;
	}
	
	/**
	 * @file ArrayFactory.java
	 * @author burgess.zhang
	 * @time 22:39:29/2018-09-11
	 * @desc 校验数组非空
	 * @param array
	 * @return
	 */
	public static <T> boolean isNotBlank(T[] array) {
		return !isBlank(array);
	}


}
